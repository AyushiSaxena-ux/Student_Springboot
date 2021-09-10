package com.example.test.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name="STUDENT_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @Column(name="ROLLNO")
    int rollNo;

    @Column(name="NAME")
    String name;

    @Column(name="ADDRESS")
    String address;

}
