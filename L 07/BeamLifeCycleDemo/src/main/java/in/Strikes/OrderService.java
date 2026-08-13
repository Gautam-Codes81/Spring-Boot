package in.Strikes;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService paymentService;
    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void palaceOrder(){
        System.out.println("Order placed");

        paymentService.pay();
    }
}
