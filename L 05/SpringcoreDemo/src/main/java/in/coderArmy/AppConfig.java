package in.coderArmy;

import in.Strikes.CardService;
import in.coderArmy.payment.CardPayment;
import in.coderArmy.payment.PaymentService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
 public class AppConfig {
 @Bean
 public User createUser(){
  return new User("gautam",22);
 }
 @Bean
public CardService createCardService(){
  return new CardService();
}
@Bean
public PaymentService createCardPayment(){
  return new CardPayment();
}
  @Bean
  public OrderService createOrderService(PaymentService paymentService){
  return new OrderService(paymentService);
  }

}
