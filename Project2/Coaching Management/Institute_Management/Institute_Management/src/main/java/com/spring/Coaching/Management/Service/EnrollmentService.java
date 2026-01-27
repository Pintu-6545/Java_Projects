package com.spring.Coaching.Management.Service;

import java.util.List;

import com.spring.Coaching.Management.Entity.Enrollment;

public interface EnrollmentService {
	
	Enrollment enrollStudent(Enrollment enrollment);

    Enrollment getEnrollmentById(Long id);

    List<Enrollment> getAllEnrollments();

    void deleteEnrollment(Long id);
}
