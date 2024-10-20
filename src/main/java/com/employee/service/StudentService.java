package com.employee.service;

import com.employee.payload.StudentDTO;

import java.util.List;

public interface StudentService {

    public StudentDTO createStudent(StudentDTO studentDTO);


    public List<StudentDTO> listOfStudent();


    public StudentDTO updateStudent(StudentDTO studentDTO,long id);

    public void deleteStudentById(long id);
}

