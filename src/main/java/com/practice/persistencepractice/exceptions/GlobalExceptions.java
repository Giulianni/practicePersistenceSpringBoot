package com.practice.persistencepractice.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptions {

    private static final Logger logger = Logger.getLogger(GlobalExceptions.class);

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handlerErrors(Exception ex, WebRequest request) {
        logger.error("Se produjo un error'. \n" + ex.getMessage() + "\n Web Request: \n*Parameter name:" + request.getParameterNames());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error inesperado, vuelva intentar más tarde, por favor.");
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> processNotFound(ResourceNotFoundException ex) {
        logger.debug(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> processBadRequest(BadRequestException ex) {
        logger.debug(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
