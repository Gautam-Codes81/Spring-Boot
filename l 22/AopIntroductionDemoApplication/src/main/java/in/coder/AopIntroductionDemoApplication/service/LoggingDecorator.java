package in.coder.AopIntroductionDemoApplication.service;

import in.coder.AopIntroductionDemoApplication.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class LoggingDecorator implements StudentService{

  private StudentServiceImpl studentServiceimpl;

  public LoggingDecorator(StudentServiceImpl studentServiceimpl){

      this.studentServiceimpl = studentServiceimpl;
  }

    @Override
    public void createStudent(Student student) {

        LoggingServiceUtil.logStart(
                "StudentServiceImpl","createStudent"
        );

        studentServiceimpl.createStudent(student);

        LoggingServiceUtil.logEnd("StudentServiceImpl","createStudent");

    }
}
