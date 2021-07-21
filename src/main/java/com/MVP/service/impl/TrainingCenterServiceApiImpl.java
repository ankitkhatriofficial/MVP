package com.MVP.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.MVP.model.entity.TrainingCenter;
import com.MVP.repository.TrainingCenterRepo;
import com.MVP.service.TrainingCenterServiceApi;

/**
 * 
 * @author Ankit Khatri
 * 
 */

/**
 * TrainingCenterServiceApiImpl => Implementation of @TrainingCenterServiceApi
 */
@Service
public class TrainingCenterServiceApiImpl implements TrainingCenterServiceApi {

	@Autowired
	private TrainingCenterRepo repository;

	/* Saving the TrainingCenter object to the database */
	@Override
	public TrainingCenter save(TrainingCenter center) {
		center.setCreatedOn(new Date()); // setting current creation date
		return repository.save(center);
	}

	/* Retrieving all the TrainingCenter objects from the database */
	@Override
	public List<TrainingCenter> findAll() {
		return repository.findAll();
	}

	/*
	 * Retrieving all the TrainingCenter objects from the database based on
	 * filtration provided.
	 */
	@Override
	public List<TrainingCenter> findAll_filter(TrainingCenter tr_center) {
		Example<TrainingCenter> example = Example.of(tr_center);
		return repository.findAll(example);
	}

}
