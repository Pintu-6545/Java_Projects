package com.spring.Coaching.Management.Service;

import java.util.List;

import com.spring.Coaching.Management.Entity.Batch;

public interface BatchService {

	   Batch saveBatch(Batch batch);

	    Batch getBatchById(Long id);

	    List<Batch> getAllBatches();

	    Batch updateBatch(Long id, Batch batch);

	    void deleteBatch(Long id);
}
