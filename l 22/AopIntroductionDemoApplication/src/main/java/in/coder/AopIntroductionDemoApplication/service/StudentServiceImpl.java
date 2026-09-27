package in.coder.AopIntroductionDemoApplication.service;

import in.coder.AopIntroductionDemoApplication.dto.Student;
import in.coder.AopIntroductionDemoApplication.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
 private StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){

//        try{
//            Thread.sleep(2000);
//        }
//        catch (Exception e){};


        studentRepository.save(student);
    }
}
