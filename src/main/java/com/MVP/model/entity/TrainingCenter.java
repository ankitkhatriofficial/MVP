package com.MVP.model.entity;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.MVP.model.ADT.Address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Ankit Khatri
 * 
 */

/**
 * TrainingCenter => Entity class, having some various fields defined below.
 */
@Document(value = "TrainingCenters")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class TrainingCenter {

	@Id
	private String centerCode; // Primary key of the Entity

	@Length(max = 40, message = "Center Name must be less than 40 characters...!")
	private String centerName;

	@NotNull(message = "Please provide the address for training center..!")
	@Valid
	private Address address;

	private int student_capacity;

	private List<String> course_offered;

	private Date createdOn;

	@Email(message = "Invalid Email..!")
	private String contactEmail;

	@NotBlank(message = "Please provide contact Number..!")
	@Pattern(regexp = "[6-9][0-9]{9}", message = "Invalid Contact Number..!")
	private String contactPhone;

}
