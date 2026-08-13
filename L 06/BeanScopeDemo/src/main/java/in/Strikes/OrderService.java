package in.Strikes;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//@Component
@Scope("singleton")
public class OrderService {

 public OrderService(){
     System.out.println("OrderService created");
 }
    public void placeOrder(){
        System.out.println("Order placed");
    }

}
