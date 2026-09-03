package in.strikes.crudSpringBootDemo.controller;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

     Student createdStudent  =  studentService.createStudent(student);
     return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
           Student studentResp = studentService.getStudent(id);
           if(studentResp == null){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
           }

           return ResponseEntity.ok(studentResp);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentService.getAllStudent();
        if(studentList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(studentList);
    }


    @PutMapping ("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentReq) {
        Student studentResp = studentService.updateStudent(id,studentReq);
        if(studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(studentResp);
    }
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
       Boolean isDeleted = studentService.deleteStudent(id);
       if(!isDeleted){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok("Record deleted");
    }
@PatchMapping("/delete-soft/{id}")
public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id){
   Boolean isDeleted = studentService.deleteStudentSoftly(id);

   if(!isDeleted){
       return ResponseEntity.notFound().build();
   }
   return ResponseEntity.ok("record deleted");

}


    }