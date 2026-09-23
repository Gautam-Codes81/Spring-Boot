package in.strikes.filterDemo2.service;

import in.strikes.filterDemo2.dto.Student;
import in.strikes.filterDemo2.dto.StudentResponseDto;
import org.apache.coyote.Response;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
    public StudentResponseDto createStudent(Student student) {

        StudentResponseDto responseDto = new StudentResponseDto();
        responseDto.setName(student.getName());
        responseDto.setMessage("Student is saved successfully");
        return responseDto;

    }

}
