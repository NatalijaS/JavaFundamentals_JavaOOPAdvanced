package _08_DependencyInversionAndInterfaceSegregation_Lab._04_Recharge;

public class RechargeStation {

    public void recharge(Rechargeable rechargeable) {
        rechargeable.recharge();
    }
}
