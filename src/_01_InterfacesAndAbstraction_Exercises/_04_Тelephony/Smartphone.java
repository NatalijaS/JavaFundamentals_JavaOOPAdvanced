package _01_InterfacesAndAbstraction_Exercises._04_Тelephony;

public class Smartphone implements Calling, Browsing {

    Smartphone() {}

    @Override
    public String call(String number) {
        if (number.matches("[0-9]*")) {
            return "Calling... " + number;
        } else {
            return "Invalid number!";
        }
    }

    @Override
    public String browse(String url) {
        if (url.matches("[^0-9]*")) {
            return "Browsing: " + url + "!";
        } else {
            return "Invalid URL!";
        }
    }
}
