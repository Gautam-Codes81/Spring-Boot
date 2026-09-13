package in.strikes.crudSpringBootDemo.service;

import in.strikes.crudSpringBootDemo.dto.CreateStudentRequestDto;
import in.strikes.crudSpringBootDemo.dto.CreateStudentResponseDto;
import in.strikes.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import in.strikes.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.repository.StudentRepository;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentRequestDto){
        Student student = mapToEntity(studentRequestDto);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        Student studentResp = studentRepository.save(student);
        return mapToDto(studentResp);

    }

    public CreateStudentResponseDto getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        if(studentResp.isPresent()){
            return mapToDto(studentResp.get());
        }
        return null;
    }

    public List<CreateStudentResponseDto> getAllStudent(){
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList.stream()
                .map(this::mapToDto)
                .toList();
    }

public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq){
        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()){
            return  null;
        }
        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setAge(studentReq.getAge());

        studentToSave.setDeleted(false);
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(studentToSave);
        return mapToUpdateDto(savedStudent);
}
public Boolean deleteStudent(Long id){
        Boolean isStudent = studentRepository.existsById(id);
        if(!isStudent) return  false;
        studentRepository.deleteById(id);
        return true;
}
public Boolean deleteStudentSoftly(Long id){
        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()){
            return false;
        }
        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
}
private Student mapToEntity(CreateStudentRequestDto studentRequestDto){
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setEmail(studentRequestDto.getEmail());
        student.setRollNo(studentRequestDto.getRollNo());
        student.setSubject(studentRequestDto.getSubject());
        student.setDeleted(false);

      return student;
    }

    private CreateStudentResponseDto mapToDto(Student student){
        CreateStudentResponseDto responseDto = new CreateStudentResponseDto();
        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());

        responseDto.setMessage("Student saved succesfully");
         return responseDto;


    }

    private UpdateStudentResponseDto mapToUpdateDto(Student student){
        UpdateStudentResponseDto responseDto = new UpdateStudentResponseDto();
        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student updated  successfully");
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return responseDto;


    }


}

