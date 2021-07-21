package com.MVP.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.MVP.model.entity.TrainingCenter;

/**
 * 
 * @author Ankit Khatri
 * 
 */

/**
 * TrainingCenter Repository => perform database operations related only
 * to @TrainingCenter
 */
@Repository
public interface TrainingCenterRepo extends MongoRepository<TrainingCenter, String> {

}
