package com.spring.Coaching.Management.Service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.Coaching.Management.Entity.Enrollment;
import com.spring.Coaching.Management.Repository.EnrollmentRepository;
import com.spring.Coaching.Management.Service.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository repository;

    public EnrollmentServiceImpl(EnrollmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Enrollment enrollStudent(Enrollment enrollment) {
        // real-world default
    	enrollment.setEnrolledDate(LocalDateTime.now());
        return repository.save(enrollment);
    }

    @Override
    public Enrollment getEnrollmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return repository.findAll();
    }

    @Override
    public void deleteEnrollment(Long id) {
        repository.deleteById(id);
    }
}