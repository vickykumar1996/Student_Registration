package com.employee.service;


import com.employee.entity.Student;
import com.employee.payload.StudentDTO;
import com.employee.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements  StudentService{


    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student=mapToEntity(studentDTO);
        Student saveEntity=studentRepository.save(student);
        StudentDTO dto=mapToDTO(saveEntity);
        dto.setMessage("data save successfully !");

        return dto;
    }
    Student mapToEntity(StudentDTO studentDTO){
        Student entity = new Student();
        entity.setId(studentDTO.getId());
        entity.setName(studentDTO.getName());
        entity.setEmail(studentDTO.getEmail());
        entity.setMobile(studentDTO.getMobile());
        entity.setCity(studentDTO.getCity());
        return entity;
    }
    StudentDTO mapToDTO(Student student){
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setMobile(student.getMobile());
        dto.setCity(student.getCity());
        return dto;
    }

    @Override
    public List<StudentDTO> listOfStudent() {
        List<Student> all = studentRepository.findAll();
        List<StudentDTO> collect = all.stream().map(e -> mapToDTO(e)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO, long id) {
        Optional<Student> byId = studentRepository.findById(id);
       Student student =byId.get();
       student.setId(studentDTO.getId());
       student.setName(studentDTO.getName());
       student.setEmail(studentDTO.getEmail());
       student.setMobile(studentDTO.getMobile());
       student.setCity(studentDTO.getCity());
      Student saveEntity= studentRepository.save(student);
      StudentDTO dto = mapToDTO(saveEntity);
        return dto;
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);

    }
}
