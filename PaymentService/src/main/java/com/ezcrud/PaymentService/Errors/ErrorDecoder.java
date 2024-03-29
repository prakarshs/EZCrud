package com.ezcrud.PaymentService.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorDecoder extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorBody> customError(CustomError exception){
        return new ResponseEntity<>(ErrorBody.builder()
                .text(":: YOU ENCOUNTERED AN ERROR ::")
                .message(exception.getMessage())
                .resolution(exception.getResolution())
                .build(), HttpStatus.NOT_FOUND);
    }
}
