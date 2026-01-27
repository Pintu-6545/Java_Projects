package com.spring.Coaching.Management.Service;

import java.util.List;

import com.spring.Coaching.Management.Entity.Institute;

public interface InstituteService {
    
	Institute saveInstitute(Institute institute);

    List<Institute> getAllInstitutes();

    Institute getInstituteById(Long id);

    Institute updateInstitute(Long id, Institute institute);

    void deleteInstitute(Long id);
}