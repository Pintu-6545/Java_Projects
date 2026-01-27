package com.spring.Coaching.Management.Service;

import java.util.List;

import com.spring.Coaching.Management.Entity.Attendance;

public interface AttendanceService {

	Attendance markAttendance(Attendance attendance);

    Attendance getAttendanceById(Long id);
    Attendance updateAttendance(Long id, Attendance attendance);

    List<Attendance> getAllAttendance();

    void deleteAttendance(Long id);
}
