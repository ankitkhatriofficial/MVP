package com.MVP.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MVP.handler.exceptions.InvalidDataException;
import com.MVP.model.entity.TrainingCenter;
import com.MVP.service.TrainingCenterServiceApi;

/**
 * 
 * @author Ankit Khatri
 * 
 */

/**
 * TrainingCenterController => Perform operations related to @TrainingCenter
 */
@RestController
public class TrainingCenterController {

	/* Auto-wiring the TrainingCenterServiceApi object */
	@Autowired
	private TrainingCenterServiceApi trainingCenterApi;

	/* End Point to save the training center to the database */
	@PostMapping("/training-centers")
	public TrainingCenter saveTrainingCenter(@Valid @RequestBody TrainingCenter tr_center, BindingResult result) {
		if (result.hasErrors()) // validating the input fields and inputed data
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());
		else
			return trainingCenterApi.save(tr_center); // saving the object to the database
	}

	/* End Point to fetch all the training centers from the database */
	@GetMapping("/training-centers")
	public List<TrainingCenter> fetchTrainingCenters() {
		return trainingCenterApi.findAll();
	}

	/*
	 * End Point to fetch all the training centers from the database based on
	 * filtration.
	 */
	@PostMapping("/training-centers/filter")
	public List<TrainingCenter> fetchTrainingCenters_by_filter(
			@RequestBody(required = false) TrainingCenter tr_center) {
		if (tr_center == null)
			return fetchTrainingCenters();
		else
			return trainingCenterApi.findAll_filter(tr_center);
	}
}
