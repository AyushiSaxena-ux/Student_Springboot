package com.example.test.sample.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentDTO {
    String name;
    int id;
    String address;
}
