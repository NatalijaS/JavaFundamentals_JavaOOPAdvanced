package _01_InterfacesAndAbstraction_Lab._03_CarShopExtended;

public interface Rentable extends Car{

    Integer getMinRentDay();

    Double getPricePerDay();
}
