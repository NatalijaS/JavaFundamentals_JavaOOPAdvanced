package exams._2017_04_19_RecyclingStation.app.core;

import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.ProcessingData;

public class BalanceManagerImpl implements BalanceManager {

    private double energyBalance;
    private double capitalBalance;

    @Override
    public void processData(ProcessingData processingData) {
        this.energyBalance += processingData.getEnergyBalance();
        this.capitalBalance += processingData.getCapitalBalance();
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }
}
