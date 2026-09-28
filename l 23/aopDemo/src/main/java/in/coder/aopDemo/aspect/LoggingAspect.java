package in.coder.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(String in.coder.aopDemo.service.StudentService.createStudent()")
//   @Before("execution(* in.coder.aopDemo.service.StudentService.createStudent(..))")

   @Before("execution(String in.coder.aopDemo.service.StudentService.createStudent())")
   public void logBeforeMethod(){

    System.out.println("Student is going to be saved");

  }

}
