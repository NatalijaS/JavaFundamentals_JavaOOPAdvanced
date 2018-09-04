package exams._2017_04_19_RecyclingStation.tests;

import exams._2017_04_19_RecyclingStation.app.waste_disposal.DefaultGarbageProcessor;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.GarbageDisposalStrategy;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.GarbageProcessor;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.ProcessingData;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.StrategyHolder;
import exams._2017_04_19_RecyclingStation.tests.fakes.DisposableAnnotation;
import exams._2017_04_19_RecyclingStation.tests.fakes.DisposableWaste;
import exams._2017_04_19_RecyclingStation.tests.fakes.NonAnnotatedWaste;
import exams._2017_04_19_RecyclingStation.tests.fakes.NonDisposableWaste;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedHashMap;
import java.util.Map;

public class GarbageProcessorShould {

    private final Map<Class, GarbageDisposalStrategy> strategies = new LinkedHashMap<>();

    private GarbageProcessor garbageProcessor;
    private StrategyHolder strategyHolderMock;
    private ProcessingData processingDataMock;
    private GarbageDisposalStrategy garbageDisposalStrategyMock;

    @Before
    public void initialize() {
        this.strategyHolderMock = Mockito.mock(StrategyHolder.class);
        this.garbageDisposalStrategyMock = Mockito.mock(GarbageDisposalStrategy.class);
        this.garbageProcessor = new DefaultGarbageProcessor(strategyHolderMock);
        this.processingDataMock = Mockito.mock(ProcessingData.class);
        this.strategies.put(DisposableAnnotation.class, this.garbageDisposalStrategyMock);
    }

    @Test
    public void returnStrategyHolderIfPresent() {
        Assert.assertEquals(this.strategyHolderMock, this.garbageProcessor.getStrategyHolder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenNullStrategyHolderIsPassed() {
        this.garbageProcessor =
                new DefaultGarbageProcessor(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenNonDisposableWasteIsProcessed() {
        this.garbageProcessor.processWaste(new NonDisposableWaste());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenNonAnnotatedWasteIsProcessed() {
        this.garbageProcessor.processWaste(new NonAnnotatedWaste());
    }

    @Test
    public void returnProcessingDataIfDisposableWastePassed() {
        //arrange
        Mockito.when(this.garbageDisposalStrategyMock.processGarbage(Mockito.isA(DisposableWaste.class)))
                .thenReturn(this.processingDataMock);
        Mockito.when(this.strategyHolderMock.getDisposalStrategies()).thenReturn(this.strategies);

        //act
        ProcessingData result = this.garbageProcessor.processWaste(new DisposableWaste());

        //assert
        Assert.assertSame(this.processingDataMock, result);
    }
}
