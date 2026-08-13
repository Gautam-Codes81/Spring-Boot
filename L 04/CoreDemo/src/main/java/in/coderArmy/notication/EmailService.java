package in.coderArmy.notication;

public class EmailService  implements NotificationService {
   @Override
    public void sendNotification(){
        System.out.println("Email notification sent");
    }

}
