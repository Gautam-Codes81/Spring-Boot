package in.coder.aopDemo.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public String createStudent(){

        System.out.println("Student saved");

        return "Student saved";
    }

}
