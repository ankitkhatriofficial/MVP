package com.MVP.model.ADT;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Ankit Khatri
 * 
 */

/**
 * Address => ADT (Abstract Data Type) with following attributes defined.
 */
@Getter
@Setter
@NoArgsConstructor
public class Address {

	@NotBlank(message = "Please provide building No..!")
	private String buildingNo;

	@NotBlank(message = "Please provide city name..!")
	private String city;

	@NotBlank(message = "Please provide state name..!")
	private String state;

	@NotBlank(message = "Please provide Pincode..!")
	@Pattern(regexp = "[\\d]{6}", message = "Invalid Pincode..!")
	private String pincode;

}
