package com.spring.Coaching.Management.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Coaching.Management.Entity.Enrollment;
import com.spring.Coaching.Management.Service.EnrollmentService;

@RestController
@RequestMapping("/api/enroll")
public class EnrollmentController {

    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    // 🔹 ENROLL STUDENT INTO BATCH
    @PostMapping
    public Enrollment enrollStudent(@RequestBody Enrollment enrollment) {
        return service.enrollStudent(enrollment);
    }

    // 🔹 GET ALL ENROLLMENTS
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return service.getAllEnrollments();
    }

    // 🔹 GET ENROLLMENT BY ID
    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable Long id) {
        return service.getEnrollmentById(id);
    }

    // 🔹 DELETE ENROLLMENT
    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        service.deleteEnrollment(id);
        return "Enrollment deleted successfully";
    }
}