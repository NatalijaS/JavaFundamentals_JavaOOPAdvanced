package exams._2017_04_19_RecyclingStation.app.core;

import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.ProcessingData;

public interface BalanceManager {

    void processData(ProcessingData processingData);

    double getEnergyBalance();

    double getCapitalBalance();
}
