package com.example.test.sample.service;

import com.example.test.sample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentFactoryImpl extends StudentFactory{
    @Autowired
    StudentRepository studentRepository;
    @Override
    StudentServiceAbstract getAppendedName(int id,String name) {
        if (name.equalsIgnoreCase("address")) {
            return new StudentByAddressServiceAbstractImpl(studentRepository);
        }else{
            return  new StudentByNameServiceAbstractImpl(studentRepository);
        }
    }
}
