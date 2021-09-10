package com.example.test.sample.repository;


import com.example.test.sample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> getAllByName(String name);
    List<Student> getAllByAddress(String address);

}
