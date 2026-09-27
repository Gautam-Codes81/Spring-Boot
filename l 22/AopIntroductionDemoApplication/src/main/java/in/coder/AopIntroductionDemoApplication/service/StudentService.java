package in.coder.AopIntroductionDemoApplication.service;

import in.coder.AopIntroductionDemoApplication.dto.Student;
import org.springframework.stereotype.Component;

//@Component
public interface StudentService {

     void createStudent(Student student);
}
