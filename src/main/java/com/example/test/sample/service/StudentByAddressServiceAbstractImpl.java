package com.example.test.sample.service;

import com.example.test.sample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentByAddressServiceAbstractImpl extends  StudentServiceAbstract{
    StudentRepository studentRepository;


    StudentByAddressServiceAbstractImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    @Override
    public void getNameById(int id) {
        name =  studentRepository.getById(id).getAddress();
    }
}
