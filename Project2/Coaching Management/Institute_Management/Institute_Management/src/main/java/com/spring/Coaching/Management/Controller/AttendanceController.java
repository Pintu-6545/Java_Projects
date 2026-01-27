package com.spring.Coaching.Management.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Coaching.Management.Entity.Attendance;
import com.spring.Coaching.Management.Service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    // MARK ATTENDANCE
    @PostMapping
    public Attendance markAttendance(@RequestBody Attendance attendance) {
        return service.markAttendance(attendance);
    }

    // GET ALL
    @GetMapping
    public List<Attendance> getAll() {
        return service.getAllAttendance();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Attendance getById(@PathVariable Long id) {
        return service.getAttendanceById(id);
    }
    
    // PUT BY Attendance
    @PutMapping("/{id}")
    public Attendance updateAttendance(
            @PathVariable Long id,
            @RequestBody Attendance attendance) {

        return service.updateAttendance(id, attendance);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteAttendance(id);
        return "Attendance deleted successfully";
    }
}