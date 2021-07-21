package com.MVP.handler.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Ankit Khatri
 * 
 */

/**
 * InvalidDataException => This class will be triggered or manually thrown
 * wherever the input data mismatch/requires.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 5754975734608361897L;
	private String message;

}
