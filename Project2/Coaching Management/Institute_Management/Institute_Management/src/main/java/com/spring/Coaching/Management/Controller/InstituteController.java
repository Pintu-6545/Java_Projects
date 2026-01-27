package com.spring.Coaching.Management.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Coaching.Management.Entity.Institute;
import com.spring.Coaching.Management.Service.InstituteService;

@RestController
@RequestMapping("/api/institute")
public class InstituteController {

    private final InstituteService instituteService;

    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }

    // CREATE
    @PostMapping
    public Institute createInstitute(@RequestBody Institute institute) {
        return instituteService.saveInstitute(institute);
    }

    // READ ALL
    @GetMapping
    public List<Institute> getAllInstitutes() {
        return instituteService.getAllInstitutes();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Institute getInstituteById(@PathVariable Long id) {
        return instituteService.getInstituteById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Institute updateInstitute(
            @PathVariable Long id,
            @RequestBody Institute institute) {
        return instituteService.updateInstitute(id, institute);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteInstitute(@PathVariable Long id) {
        instituteService.deleteInstitute(id);
        return "Institute deleted successfully";
    }
}