package com.spring.Coaching.Management.Service;

import java.util.List;

import com.spring.Coaching.Management.Entity.Course;

public interface CourseService {

	 Course saveCourse(Course course);
	    List<Course> getAllCourses();
	    
	    Course getCourseById(Long id);
	    
	    Course updateCourse(Long id, Course course);

	    void deleteCourse(Long id);
}
