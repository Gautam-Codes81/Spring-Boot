package in.coderArmy;

import in.Strikes.CardService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

//        User user = context.getBean(User.class);
//        System.out.println(user.getName());
//        CardService card = context.getBean(CardService.class);
//        card.addToCard();
    }
}
