package com.spring.Coaching.Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Coaching.Management.Entity.Batch;
import com.spring.Coaching.Management.Service.BatchService;

@RestController
@RequestMapping("/api/batch")
public class BatchController {

    private final BatchService service;

    public BatchController(BatchService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Batch create(@RequestBody Batch batch) {
        return service.saveBatch(batch);
    }

    // GET ALL
    @GetMapping
    public List<Batch> getAll() {
        return service.getAllBatches();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Batch getById(@PathVariable Long id) {
        return service.getBatchById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Batch update(@PathVariable Long id, @RequestBody Batch batch) {
        return service.updateBatch(id, batch);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteBatch(id);
        return "Batch deleted successfully";
    }
}