package com.spring.Coaching.Management.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.Coaching.Management.Entity.Institute;
import com.spring.Coaching.Management.Repository.InstituteRepository;
import com.spring.Coaching.Management.Service.InstituteService;

@Service
public class InstituteServiceImpl implements InstituteService {

    private final InstituteRepository instituteRepository;

    public InstituteServiceImpl(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }

    @Override
    public Institute saveInstitute(Institute institute) {
        return instituteRepository.save(institute);
    }

    @Override
    public List<Institute> getAllInstitutes() {
        return instituteRepository.findAll();
    }

    @Override
    public Institute getInstituteById(Long id) {
        return instituteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Institute not found with id: " + id));
    }

    @Override
    public Institute updateInstitute(Long id, Institute institute) {
        Institute existing = getInstituteById(id);

        existing.setName(institute.getName());
        existing.setAddress(institute.getAddress());
        existing.setEmail(institute.getEmail());
        existing.setContact(institute.getContact());

        return instituteRepository.save(existing);
    }

    @Override
    public void deleteInstitute(Long id) {
        instituteRepository.deleteById(id);
    }
}