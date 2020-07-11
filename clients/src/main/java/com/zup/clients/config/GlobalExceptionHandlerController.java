package com.zup.clients.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

	@ExceptionHandler(Exception.class)
	public void handleException(HttpServletResponse res, Exception ex) throws IOException {
		System.out.println(ex.getMessage());
		res.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
	}

}
