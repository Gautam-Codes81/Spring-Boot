package in.Strikes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context  = new AnnotationConfigApplicationContext(AppConfig.class);
//        OrderService order = context.getBean(OrderService.class);
//        order.palaceOrder();
//
//        AppConfig config = context.getBean(AppConfig.class);
//        config.demo();

        CardService card = context.getBean(CardService.class);
        //card.getValue(1);
        System.out.println(card.getValue(1));

    }
}
