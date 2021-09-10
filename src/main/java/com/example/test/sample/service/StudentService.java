package com.example.test.sample.service;

import com.example.test.sample.dto.StudentDTO;

import java.util.List;


public interface StudentService {


    StudentDTO getStudentById(int id);

    List<StudentDTO> getStudentByName(String name);

    List<StudentDTO> getStudentByAddress(String address);

    public StudentDTO addStudent(StudentDTO studentDTO);
    public void deleteStudent(int id);
    public StudentDTO updateStudent(StudentDTO s);
}
