package in.coderArmy.notication;

public class SmsService implements NotificationService {

    @Override
    public void sendNotification(){
        System.out.println("SMS notication sent");
    }
}
