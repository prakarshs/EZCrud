package com.ezcrud.PaymentService.Errors;

import lombok.Data;

@Data
public class CustomError extends RuntimeException{
    private String resolution;
    public CustomError(String message, String resolution){
        super(message);
        this.resolution=resolution;

    }
}
