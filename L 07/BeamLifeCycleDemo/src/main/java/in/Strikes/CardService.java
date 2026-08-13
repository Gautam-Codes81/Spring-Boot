package in.Strikes;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
//@Component
public class CardService implements BeanNameAware, ApplicationContextAware /* implements  InitializingBean */{

  Map<Integer,String> mp;

  public CardService(){
      mp = new HashMap<>();
      System.out.println("CardService constructor called");
  }

  public void setBeanName(String name) {
    System.out.println("Bean is created " + name);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println("ApplicationContext name is"+applicationContext.getApplicationName());
  }
  @PostConstruct
  public void start2(){
    System.out.println("Bean is ready");
     mp.put(1,"Aditya");
     mp.put(2,"Rohit");

  }


  public void AddToCard(){

    System.out.println("Added to card");
  }

  public String getValue(int key){
    return mp.get(key);
  }



  //@Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Bean is ready");
//     mp.put(1,"Aditya");
//     mp.put(2,"Rohit");
//    }
 // @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Bean is ready");
//     mp.put(1,"Aditya");
//     mp.put(2,"Rohit");
//    }

}
