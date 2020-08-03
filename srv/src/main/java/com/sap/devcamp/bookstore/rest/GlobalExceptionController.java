package com.sap.devcamp.bookstore.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {

    /**
     * Exception Handler for Exception. Returns API response wit http code 500
     * @param response response provided by spring
     * @throws IOException
     */
    @ExceptionHandler(value = { Exception.class })
    protected void internalServerError(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
