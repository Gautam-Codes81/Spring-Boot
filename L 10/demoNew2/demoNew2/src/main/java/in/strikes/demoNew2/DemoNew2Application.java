package in.strikes.demoNew2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLOutput;

@SpringBootApplication
public class DemoNew2Application {

	public static void main(String[] args) {

		ApplicationContext context =
		SpringApplication.run(DemoNew2Application.class, args);

//		PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
//		paymentGateway.print();

//		paymentGateway.setType("Paytm");
//		paymentGateway.setRetryCount(5);
//		System.out.println(paymentGateway.getType());
//		System.out.println(paymentGateway.getRetryCount());
//		System.out.println(paymentGateway.isEnabled());
//		System.out.println(paymentGateway.getTimeout());

	}


}
// application.properties