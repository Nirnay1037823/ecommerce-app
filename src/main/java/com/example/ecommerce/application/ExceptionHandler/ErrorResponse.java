package com.example.ecommerce.application.ExceptionHandler;

//Creates a general case error handler with properties like errorCode and Message
public class ErrorResponse {
    private int errorCode;  //Stores errorCode

    private String message; //Stores errorMessage

    public int getErrorCode(){
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
