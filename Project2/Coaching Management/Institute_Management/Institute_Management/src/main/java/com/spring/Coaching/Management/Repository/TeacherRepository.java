package com.spring.Coaching.Management.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Coaching.Management.Entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	// For teacher dashboard after login
	 Optional<Teacher> findByUserId(Long userId);
}
