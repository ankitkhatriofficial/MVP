package com.MVP.handler.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.MVP.model.response.ResponseMessage;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

/**
 * 
 * @author Ankit Khatri
 * 
 */

/**
 * GlobalExceptionsHandler => Handles all the exceptions occur frequently or
 * unexpectedly exceptions arise, provides a better and readable error message
 * to the response.
 */
@ControllerAdvice
public class GlobalExceptionsHandler {

	/*
	 * Utility Function to get the ResponseEntity object for a particular exception
	 */
	private ResponseEntity<ResponseMessage> exception(String message, int statusCode, HttpStatus status,
			WebRequest request) {
		ResponseMessage errorMsg = new ResponseMessage(statusCode, status, message, new Date());
		return new ResponseEntity<>(errorMsg, status);
	}

	/* Handles the {Invalid Data (Input Mismatch, Input required)} */
	@ExceptionHandler(value = { InvalidDataException.class })
	public ResponseEntity<ResponseMessage> exception(InvalidDataException exception, WebRequest request) {
		ResponseMessage errorMsg = new ResponseMessage(400, HttpStatus.BAD_REQUEST, exception.getMessage(), new Date());
		return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
	}

	/* Handles the {Anonymous HttpRequest to an end point to the server} */
	@ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
	public ResponseEntity<ResponseMessage> exception(HttpRequestMethodNotSupportedException exception,
			WebRequest request) {
		ResponseMessage errorMsg = new ResponseMessage(405, HttpStatus.METHOD_NOT_ALLOWED, exception.getMessage(),
				new Date());
		return new ResponseEntity<>(errorMsg, HttpStatus.METHOD_NOT_ALLOWED);
	}

	/* Handles the {JSON Parsing, Input Validation, Input Range} */
	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
	public ResponseEntity<ResponseMessage> exception2(HttpMessageNotReadableException exception, WebRequest request) {

		if (exception.contains(MismatchedInputException.class))
			return exception("Input Mismatch : check the API docs...!", 400, HttpStatus.BAD_REQUEST, request);
		else if (exception.contains(JsonMappingException.class))
			return exception(exception.getMostSpecificCause().getLocalizedMessage().split("\n")[0], 400,
					HttpStatus.BAD_REQUEST, request);

		ResponseMessage errorMsg = new ResponseMessage(400, HttpStatus.BAD_REQUEST,
				exception.getLocalizedMessage().split(":")[0], new Date());
		return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
	}

	/* Handles {404 (NOT FOUND)} */
	@ExceptionHandler(value = { NoHandlerFoundException.class })
	public ResponseEntity<ResponseMessage> exception(NoHandlerFoundException exception, WebRequest request) {
		ResponseMessage errorMsg = new ResponseMessage(404, HttpStatus.NOT_FOUND, "NOT FOUND", new Date());
		return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
	}

	/* Handles {500 (Server Error), any other anonymous/unknown exceptions} */
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ResponseMessage> exception(Exception exception, WebRequest request) {
		ResponseMessage errorMsg = new ResponseMessage(500, HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error",
				new Date());
		return new ResponseEntity<>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
