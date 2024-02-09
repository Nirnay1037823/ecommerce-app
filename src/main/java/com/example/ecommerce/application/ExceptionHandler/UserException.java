package com.example.ecommerce.application.ExceptionHandler;

public class UserException extends Exception{
    private String errorMessage;

    public UserException(){

    }

    public UserException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }
}
