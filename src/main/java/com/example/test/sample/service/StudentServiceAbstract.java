package com.example.test.sample.service;

import com.example.test.sample.entity.Student;

public abstract class StudentServiceAbstract {
    String name;
    public abstract void getNameById(int id);
    public String appendNameWithRollNo(int id){
        return name+"-"+id;
    }
}
