package com.MVP.model.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Ankit Khatri
 * 
 */

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ResponseMessage {
	/**
	 * ResponseMessage => Default Response of the
	 * controller/exceptions/success/failure operations. Only these four fields will
	 * always be responded if any exception occurs, no extra information will be
	 * leaked.
	 */
	private int statusCode;
	private HttpStatus status;
	private String message;
	private Date timestamp;
}
