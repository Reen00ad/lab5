package com.example.lab5.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name,degree,status;
    private int age;
}
