package exams._2017_04_19_RecyclingStation.app.core;


import exams._2017_04_19_RecyclingStation.app.factories.Factory;
import exams._2017_04_19_RecyclingStation.app.io.Reader;
import exams._2017_04_19_RecyclingStation.app.io.Writer;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.annotations.Disposable;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.GarbageDisposalStrategy;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.GarbageProcessor;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.ProcessingData;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.Waste;

import java.io.IOException;
import java.lang.annotation.Annotation;

public class Engine implements Runnable {

    private static final String SUCCESS = "%.2f kg of %s successfully processed!%n";
    private static final String FAILURE = "The passed in garbage does not implement an annotation implementing the Disposable meta-annotation or is not supported by the StrategyHolder.";
    private static final String STATUS = "Energy: %.2f Capital: %.2f%n";
    private static final String INVALID_COMMAND = "Invalid command";

    private Reader reader;
    private Writer writer;
    private GarbageProcessor garbageProcessor;
    private BalanceManager balanceManager;
    private Factory<Waste> wasteFactory;
    private Factory<GarbageDisposalStrategy> strategyFactory;

    public Engine(
            Reader reader,
            Writer writer,
            GarbageProcessor garbageProcessor,
            BalanceManager balanceManager,
            Factory<Waste> wasteFactory,
            Factory<GarbageDisposalStrategy> strategyFactory) {
        this.reader = reader;
        this.writer = writer;
        this.garbageProcessor = garbageProcessor;
        this.balanceManager = balanceManager;
        this.wasteFactory = wasteFactory;
        this.strategyFactory = strategyFactory;
    }

    @Override
    public void run() {
        String line;
        try {
            while (!("TimeToRecycle").equals(line = this.reader.read())) {
                String[] cmdArgs = line.split("\\s+");
                String cmdType = cmdArgs[0];

                switch (cmdType) {
                    case "ProcessGarbage":
                        this.writer.write(this.processGarbage(cmdArgs[1]));
                        break;
                    case "Status":
                        this.writer.write(this.getStatus());
                        break;
                    default:
                        this.writer.write(INVALID_COMMAND);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getStatus() {
        return String.format(
                STATUS,
                this.balanceManager.getEnergyBalance(),
                this.balanceManager.getCapitalBalance());
    }

    private String processGarbage(String parameters) {
        String[] args = parameters.split("\\|");
        String name = args[0];
        double weight = Double.parseDouble(args[1]);

        try {
            Waste waste = this.wasteFactory.create(args);
            this.loadStrategy(waste);
            ProcessingData processingData = this.garbageProcessor.processWaste(waste);
            this.balanceManager.processData(processingData);
            return String.format(SUCCESS, weight, name);
        } catch (Exception e) {
            //TODO: handle exceptions properly
            return FAILURE;
        }
    }

    private Class<? extends Annotation> getDisposableAnnotationClass(Waste waste) {
        for (Annotation annotation : waste.getClass().getAnnotations()) {
            if (annotation.annotationType().isAnnotationPresent(Disposable.class)) {
                return annotation.annotationType();
            }
        }

        return null;
    }

    private void loadStrategy(Waste waste) throws Exception {
        Class<? extends Annotation> annotationClass = this.getDisposableAnnotationClass(waste);
        if (annotationClass == null) {
            throw new IllegalArgumentException(
                    "The passed in garbage does not implement an annotation implementing the Disposable meta-annotation or is not supported by the StrategyHolder.");
        }

        if (!this.garbageProcessor.getStrategyHolder().getDisposalStrategies().containsKey(annotationClass)) {
            GarbageDisposalStrategy garbageDisposalStrategy = this.strategyFactory.create(annotationClass.getSimpleName());
            this.garbageProcessor.getStrategyHolder().addStrategy(annotationClass, garbageDisposalStrategy);
        }
    }
}
