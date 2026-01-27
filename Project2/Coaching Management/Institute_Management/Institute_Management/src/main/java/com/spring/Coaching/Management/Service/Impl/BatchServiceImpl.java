package com.spring.Coaching.Management.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Coaching.Management.Entity.Batch;
import com.spring.Coaching.Management.Entity.Course;
import com.spring.Coaching.Management.Entity.Teacher;
import com.spring.Coaching.Management.Repository.BatchRepository;
import com.spring.Coaching.Management.Repository.CourseRepository;
import com.spring.Coaching.Management.Repository.TeacherRepository;
import com.spring.Coaching.Management.Service.BatchService;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchRepository repository;

    public BatchServiceImpl(BatchRepository repository) {
        this.repository = repository;
    }

    @Override
    public Batch saveBatch(Batch batch) {
        return repository.save(batch);
    }

    @Override
    public Batch getBatchById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Batch not found with id: " + id));
    }

    @Override
    public List<Batch> getAllBatches() {
        return repository.findAll();
    }

    @Override
    public Batch updateBatch(Long id, Batch batch) {
        Batch existing = getBatchById(id);

        existing.setBatchName(batch.getBatchName());
        existing.setTiming(batch.getTiming());
        existing.setCourse(batch.getCourse());
        existing.setTeacher(batch.getTeacher());

        return repository.save(existing);
    }

    @Override
    public void deleteBatch(Long id) {
        repository.deleteById(id);
    }
}
