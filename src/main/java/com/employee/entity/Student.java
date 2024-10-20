package com.employee.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "student")
public class Student {
    @Id
    private long id;
    
    private String name;

    private String email;

    private String mobile;
    private String city;

}
