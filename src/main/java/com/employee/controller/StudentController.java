package com.employee.controller;

import com.employee.payload.StudentDTO;
import com.employee.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/registration")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<?>addStudent(@Valid @RequestBody StudentDTO studentDTO, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.CREATED);
        }
       StudentDTO studentDTO1 =studentService.createStudent(studentDTO);
        return new ResponseEntity<>(studentDTO1, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<StudentDTO>>studentList(){
        List<StudentDTO> studentDTOS = studentService.listOfStudent();
        return new ResponseEntity<>(studentDTOS,HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(long id){
        studentService.deleteStudentById(id);
        return new ResponseEntity<>("Data is deleted",HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO,@RequestParam long id){
        StudentDTO studentDTO1 = studentService.updateStudent(studentDTO, id);
        return new ResponseEntity<>(studentDTO1,HttpStatus.OK);
    }


}
