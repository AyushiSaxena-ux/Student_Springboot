package com.example.test.sample.service;

import com.example.test.sample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class StudentByNameServiceAbstractImpl extends  StudentServiceAbstract{

    StudentRepository studentRepository;

    public StudentByNameServiceAbstractImpl(StudentRepository studentRepository){
       this.studentRepository = studentRepository;
   }

    @Override
    public void getNameById(int id) {
        name =  studentRepository.getById(id).getName();

    }
}
