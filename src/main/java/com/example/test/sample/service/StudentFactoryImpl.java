package com.example.test.sample.service;

import com.example.test.sample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public class StudentFactoryImpl extends StudentFactory{



    @Override
   public StudentServiceAbstract getAppendedName(String name,  StudentRepository studentRepository) {
        if (name.equalsIgnoreCase("address")) {
            return new StudentByAddressServiceAbstractImpl(studentRepository);
        }else{
            return  new StudentByNameServiceAbstractImpl(studentRepository);
        }
    }
}
