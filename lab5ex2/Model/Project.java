package com.example.lab5ex2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    private String id,title,description,status,companyName;
}
