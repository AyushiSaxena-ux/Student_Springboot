package com.example.test.sample.controller;

import com.example.test.sample.dto.StudentDTO;
import com.example.test.sample.repository.StudentRepository;
import com.example.test.sample.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
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

    @GetMapping(value = "/getStudent", produces  = MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO getStudentNameOrAddress(@RequestParam(value = "id") int id, @RequestParam(value = "choice") String choice){
     StudentFactory studentFactory = FactoryCreator.getFactory();
        StudentServiceAbstract studentServiceAbstract = studentFactory.getAppendedName(choice, studentRepository);
        studentServiceAbstract.getNameById(id);

        return StudentDTO.builder().name(studentServiceAbstract.appendNameWithRollNo(id)).id(id).build();

    }
}
