package in.strikes.crudSpringBootDemo.controller;

import in.strikes.crudSpringBootDemo.dto.CreateStudentRequestDto;
import in.strikes.crudSpringBootDemo.dto.CreateStudentResponseDto;
import in.strikes.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import in.strikes.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping("create")
    public ResponseEntity<CreateStudentResponseDto> createStudent(
            @Valid  @RequestBody CreateStudentRequestDto studentRequestDto){

     CreateStudentResponseDto createdStudent  =  studentService.createStudent(studentRequestDto);
     return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);

    }

    @GetMapping("/get")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@RequestParam Long id) {
           CreateStudentResponseDto studentResp = studentService.getStudent(id);
           if(studentResp == null){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
           }

           return ResponseEntity.ok(studentResp);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent() {
        List<CreateStudentResponseDto> studentList = studentService.getAllStudent();
        if(studentList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(studentList);
    }


    @PutMapping ("/update")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id,
                                                                  @RequestBody UpdateStudentRequestDto  studentReq) {
        UpdateStudentResponseDto studentResp = studentService.updateStudent(id,studentReq);
        if(studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(studentResp);
    }
     @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
       Boolean isDeleted = studentService.deleteStudent(id);
       if(!isDeleted){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok("Record deleted");
    }
@PatchMapping("/delete-soft")
public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
   Boolean isDeleted = studentService.deleteStudentSoftly(id);

   if(!isDeleted){
       return ResponseEntity.notFound().build();
   }
   return ResponseEntity.ok("record deleted");

}


    }