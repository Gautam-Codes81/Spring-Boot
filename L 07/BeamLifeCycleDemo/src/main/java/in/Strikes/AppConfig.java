package in.Strikes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    public void demo(){
        System.out.println("demo gk");
    }
    @Bean(initMethod = "start")
    public CardService getCartBean(){
        return new CardService();
    }

}
