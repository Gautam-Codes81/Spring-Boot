package in.coderArmy;

import in.coderArmy.notication.EmailService;
import in.coderArmy.notication.NotificationService;
import in.coderArmy.notication.PopUpNotificationService;
import in.coderArmy.notication.SmsService;

public class OrderService {

    NotificationService notification;
    public OrderService(NotificationService notification){
        this.notification = notification;
    }
    public void placeOrder(){
    System.out.println("order placed");
        notification.sendNotification();

}

}
