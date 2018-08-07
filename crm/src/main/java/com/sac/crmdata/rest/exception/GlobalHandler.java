package com.sac.crmdata.rest.exception;

import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = {"com.sac.crmdata"})
@RestController
public class GlobalHandler extends ResponseEntityExceptionHandler{

	private static final Logger logger = LogManager.getLogger(GlobalHandler.class);
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		System.out.println("page not found");
		return super.handleNoHandlerFoundException(ex, headers, status, request);
	}

	@ExceptionHandler(NoSuchElementException.class)
	@ResponseBody
	public final ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {
		logger.error("No Such Element Exception: " + ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + ex.getMessage() + "\"}");
	}
}
