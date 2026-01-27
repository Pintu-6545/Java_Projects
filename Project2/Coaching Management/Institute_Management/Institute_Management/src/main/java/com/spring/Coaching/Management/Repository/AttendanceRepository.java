package com.spring.Coaching.Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Coaching.Management.Entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
