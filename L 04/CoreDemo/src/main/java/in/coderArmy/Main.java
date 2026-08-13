package in.coderArmy;

import in.coderArmy.notication.NotificationService;
import in.coderArmy.notication.PopUpNotificationService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        NotificationService notification = new  PopUpNotificationService();
        OrderService order = new OrderService(notification);
        order.placeOrder();

    }
}
