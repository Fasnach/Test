package com.store.bookStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ BookStoreException.class })
	public final ResponseEntity<Object> handleAppException(RuntimeException ex, WebRequest request) {
		BookStoreException bookStoreException = (BookStoreException) ex;
		return new ResponseEntity<Object>(bookStoreException, HttpStatus.BAD_REQUEST);
	}

}
