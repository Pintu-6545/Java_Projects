package com.spring.Coaching.Management.Service;

import java.util.List;

import com.spring.Coaching.Management.Entity.Teacher;

public interface TeacherService {
	Teacher saveTeacher(Teacher teacher);

    List<Teacher> getAllTeachers();

    Teacher getTeacherById(Long id);

    Teacher getTeacherByUserId(Long userId);
    Teacher updateTeacher(Long id, Teacher teacher);

    void deleteTeacher(Long id);
}
