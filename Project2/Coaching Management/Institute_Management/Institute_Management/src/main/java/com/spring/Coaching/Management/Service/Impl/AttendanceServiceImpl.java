package com.spring.Coaching.Management.Service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.Coaching.Management.Entity.Attendance;
import com.spring.Coaching.Management.Repository.AttendanceRepository;
import com.spring.Coaching.Management.Service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository repository;

    public AttendanceServiceImpl(AttendanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Attendance markAttendance(Attendance attendance) {

        // Auto set attendance time (real-world)
        attendance.setAttendanceDate(LocalDateTime.now());

        return repository.save(attendance);
    }

    @Override
    public Attendance getAttendanceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with id: " + id));
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return repository.findAll();
    }

    @Override
    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {

        Attendance existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with id: " + id));

        // update fields (real-world)
        existing.setPresent(updatedAttendance.getPresent());
        existing.setStudent(updatedAttendance.getStudent());
        existing.setBatch(updatedAttendance.getBatch());

        // OPTIONAL: update time when edited
        existing.setAttendanceDate(LocalDateTime.now());

        return repository.save(existing);
    }

    
    @Override
    public void deleteAttendance(Long id) {
        repository.deleteById(id);
    }
}