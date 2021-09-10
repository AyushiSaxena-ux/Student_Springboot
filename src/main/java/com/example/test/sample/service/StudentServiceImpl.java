package com.example.test.sample.service;


import com.example.test.sample.dto.StudentDTO;
import com.example.test.sample.entity.Student;
import com.example.test.sample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{

    StudentRepository studentRepository;
    @Autowired
    StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public StudentDTO getStudentById(int id){
        Student student = studentRepository.getById(id);
        return StudentDTO.builder().name(student.getName()).id(student.getRollNo()).address(student.getAddress()).build();
        /*if(id ==1){
            return Student.builder().name("Ayu").address("abc").id(1).build();
        }else  if(id ==2){
            return Student.builder().name("Ayushi").address("abcd").build();
        } else if(id ==3){
            return Student.builder().name("shrish").address("abcde").build();
        }else {
            return Student.builder().name("shrishsaxena").address("abcdef").build();
        }*/

    }

    @Override
    public List<StudentDTO> getStudentByName(String name){
        List<StudentDTO> studentDTOList = new ArrayList<>();

        studentRepository.getAllByName(name).forEach(student -> {
            studentDTOList.add(StudentDTO.builder().name(student.getName()).id(student.getRollNo()).address(student.getAddress()).build());
        });
        return studentDTOList;
    }

    @Override
    public List<StudentDTO> getStudentByAddress(String address){
        List<StudentDTO> studentDTOList = new ArrayList<>();

        studentRepository.getAllByAddress(address).forEach(student -> {
            studentDTOList.add(StudentDTO.builder().name(student.getName()).id(student.getRollNo()).address(student.getAddress()).build());
        });
        return studentDTOList;
    }

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO){
        studentRepository.save(new com.example.test.sample.entity.Student(studentDTO.getId(), studentDTO.getName(),studentDTO.getAddress()));
        return studentDTO;
    }
   @Override
    public void deleteStudent(int id){
            studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO s){
        Student student = studentRepository.getById(s.getId());
        student.setAddress(s.getAddress());
        if(!(s.getName() == null || s.getName().isEmpty() || s.getName().isBlank() ||
                s.getName().equalsIgnoreCase(""))){
            student.setName(s.getName());
        }
        if(!(s.getAddress() == null || s.getAddress().isEmpty() || s.getAddress().isBlank() ||
                s.getAddress().equalsIgnoreCase(""))) {
            student.setAddress(s.getAddress());
        }
        Student studentUpdated = studentRepository.save(student);
        return StudentDTO.builder().name(studentUpdated.getName()).address(studentUpdated.getAddress()).id(studentUpdated.getRollNo()).build();
    }
}
