package exams._2017_04_19_RecyclingStation.app;

import exams._2017_04_19_RecyclingStation.app.core.BalanceManager;
import exams._2017_04_19_RecyclingStation.app.core.BalanceManagerImpl;
import exams._2017_04_19_RecyclingStation.app.core.Engine;
import exams._2017_04_19_RecyclingStation.app.factories.Factory;
import exams._2017_04_19_RecyclingStation.app.factories.StrategyFactory;
import exams._2017_04_19_RecyclingStation.app.factories.WasteFactory;
import exams._2017_04_19_RecyclingStation.app.io.ConsoleReader;
import exams._2017_04_19_RecyclingStation.app.io.ConsoleWriter;
import exams._2017_04_19_RecyclingStation.app.io.Reader;
import exams._2017_04_19_RecyclingStation.app.io.Writer;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.DefaultGarbageProcessor;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.GarbageDisposalStrategy;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.GarbageProcessor;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.Waste;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor();

        BalanceManager balanceManager = new BalanceManagerImpl();

        Factory<Waste> wasteFactory = new WasteFactory("exams._2017_04_19_RecyclingStation.app.domain.wastes.");

        Factory<GarbageDisposalStrategy> strategyFactory =
                new StrategyFactory("exams._2017_04_19_RecyclingStation.app.domain.strategies.");

        Engine engine = new Engine(reader, writer, garbageProcessor, balanceManager, wasteFactory, strategyFactory);
        engine.run();
    }
}
