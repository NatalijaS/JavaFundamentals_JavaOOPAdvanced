package _08_DependencyInversionAndInterfaceSegregation_Lab._02_Services;

public class EmailNotificationService implements NotificationService {

    private boolean isActive;

    public EmailNotificationService(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public void sendNotification() {

    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }
}
