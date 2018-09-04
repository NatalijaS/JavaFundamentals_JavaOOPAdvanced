package _08_DependencyInversionAndInterfaceSegregation_Lab._02_Services;

public class SmsNotificationService implements NotificationService {

    @Override
    public void sendNotification() {

    }

    @Override
    public boolean isActive() {
        return false;
    }
}
