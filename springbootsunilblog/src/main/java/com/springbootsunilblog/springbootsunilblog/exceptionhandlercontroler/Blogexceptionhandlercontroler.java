package com.springbootsunilblog.springbootsunilblog.exceptionhandlercontroler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springbootsunilblog.springbootsunilblog.exception.Blogexeceptionhandler;
@RestController
@ControllerAdvice
public class Blogexceptionhandlercontroler  extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public ResponseEntity<?> exceptionhandler (Blogexeceptionhandler bloghandler,WebRequest request){
	
		return new ResponseEntity<Object>(bloghandler.getMessage(), HttpStatus.BAD_REQUEST);
		
	}

}
