package _08_DependencyInversionAndInterfaceSegregation_Lab._05_SecuritySystem;

public class KeyCardCheck extends SecurityCheck {

    private KeyCardUI keyCardUI;

    public KeyCardCheck(KeyCardUI keyCardUI) {
        this.keyCardUI = keyCardUI;
    }

    @Override
    public boolean validateUser() {
        String code = keyCardUI.requestKeyCard();

        if (isValid(code)) {
            return true;
        }

        return false;
    }

    private boolean isValid(String code) {
        return false;
    }
}
