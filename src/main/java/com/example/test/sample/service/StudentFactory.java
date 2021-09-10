package com.example.test.sample.service;

import com.example.test.sample.repository.StudentRepository;

public abstract class StudentFactory {

    public abstract  StudentServiceAbstract getAppendedName(String name, StudentRepository studentRepository);
}
