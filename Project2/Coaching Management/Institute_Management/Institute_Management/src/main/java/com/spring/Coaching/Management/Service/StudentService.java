package com.spring.Coaching.Management.Service;

import java.util.List;

import com.spring.Coaching.Management.Entity.Student;

public interface StudentService {

	Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student getStudentByUserId(Long userId);
    
    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);
}
