package com.spring.Coaching.Management.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.Coaching.Management.Entity.Course;
import com.spring.Coaching.Management.Repository.CourseRepository;
import com.spring.Coaching.Management.Service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    @Override
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course existing = getCourseById(id);

        existing.setCourseName(course.getCourseName());
        existing.setDescription(course.getDescription());
        existing.setFee(course.getFee());
        existing.setCimage(course.getCimage());
        existing.setDuration(course.getDuration());

        return repository.save(existing);
    }

    @Override
    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }
}