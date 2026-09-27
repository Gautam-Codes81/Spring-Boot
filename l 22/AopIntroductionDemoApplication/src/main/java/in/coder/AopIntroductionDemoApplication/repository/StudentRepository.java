package in.coder.AopIntroductionDemoApplication.repository;

import in.coder.AopIntroductionDemoApplication.dto.Student;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;

@Repository
public class StudentRepository {

    public void save(Student student) {
        System.out.println("Student saved");
    }
}
