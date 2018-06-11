package com.test.spring.boot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.test.spring.boot.exception.CommonsException;
import com.test.spring.boot.exception.ErrorDTO;


@ControllerAdvice
public class ErrorHandlingController {	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorDTO> processRuntimeException(HttpServletRequest req, RuntimeException ex) throws Exception {
	    ErrorDTO errorDTO;
	    ResponseStatus responseStatus = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
	    if (responseStatus != null) {
	        errorDTO = new ErrorDTO(req.getRequestURI(), responseStatus.value().toString(), ex.getMessage());
	    } else {
	        errorDTO = new ErrorDTO(req.getRequestURI(), HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
	    }	  
	    return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.valueOf(Integer.valueOf(errorDTO.getCode())));
	}
//	@ExceptionHandler(CommonsException.class)
//	public ResponseEntity<ErrorDTO> processSystemException(HttpServletRequest req, CommonsException ex) throws Exception {
//		ErrorDTO errorDTO;
//		ResponseStatus responseStatus = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
//		if (responseStatus != null) {
//			errorDTO = new ErrorDTO(req.getRequestURI(), responseStatus.value().toString(), ex.getMessage());
//		} else {
//			errorDTO = new ErrorDTO(req.getRequestURI(), HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
//		}	  
//		return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.valueOf(Integer.valueOf(errorDTO.getCode())));
//	}
}
