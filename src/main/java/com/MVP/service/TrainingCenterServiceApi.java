package com.MVP.service;

import java.util.List;

import com.MVP.model.entity.TrainingCenter;

/**
 * 
 * @author Ankit Khatri
 * 
 */

/**
 * TrainingCenterServiceApi => Offer Apis related to @TrainingCenter which would
 * be used by controllers to perform database operations.
 */
public interface TrainingCenterServiceApi {

	/* To save a TrainingCenter to the database */
	public TrainingCenter save(TrainingCenter obj);

	/* To retrieve all TrainingCenters from the database */
	public List<TrainingCenter> findAll();

	/* To retrieve all TrainingCenters from the database based on filtration */
	public List<TrainingCenter> findAll_filter(TrainingCenter tr_center);

}
