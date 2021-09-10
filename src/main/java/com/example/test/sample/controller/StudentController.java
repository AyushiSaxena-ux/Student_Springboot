package com.example.test.sample.controller;

import com.example.test.sample.dto.StudentDTO;
import com.example.test.sample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping(value = "getStudent/{id}",produces = "application/json")
    public StudentDTO getStudentById(@PathVariable int id){
       return studentService.getStudentById(id);
    }

    @GetMapping(value = "getStudentByName/{name}",produces = "application/json")
    public List<StudentDTO> getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping(value = "getStudentByAddress",produces = "application/json")
    public List<StudentDTO> getStudentByAddress(@RequestParam(value = "address") String address) {
        return studentService.getStudentByAddress(address);
    }


    @PostMapping(value = "/addStudent", produces = "application/json")
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO){
        return studentService.addStudent(studentDTO);
    }
    @DeleteMapping (value = "deleteStudent/{id}", produces = "application/json")
    public void deleteStudent(@PathVariable int id){
          studentService.deleteStudent(id);

    }

    @PostMapping(value = "/updateStudent", produces = "application/json")
      public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO){
        return  studentService.updateStudent(studentDTO);
    }

}
