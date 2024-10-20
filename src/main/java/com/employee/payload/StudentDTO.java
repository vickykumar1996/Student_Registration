package com.employee.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentDTO {
    private long id;
    @Size(min=2,message = "Should be more than 2 character")
    private String name;
    @Email(message = "Invalid email")
    private String email;
    @Size(min=10,max=10,message = "mobile number should be 10 digit")
    private String mobile;
    private String city;
    private String message;

}
