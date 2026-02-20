package com.springboot.web.exception;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.springboot.web.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<HashMap<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

		HashMap<String, String> errors = new HashMap<>();

		//		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
		//			errors.put(error.getField(), error.getDefaultMessage());
		//		}


		exception.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		ResponseEntity<HashMap<String, String>> rs = new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);  
		return rs;
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException exception, HttpServletRequest request) {

		ErrorResponse er = new ErrorResponse();

		er.setStatus(HttpStatus.NOT_FOUND.value());
		er.setMessage(exception.getMessage());

		ResponseEntity<ErrorResponse> rs = new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
		return rs;
	}

}