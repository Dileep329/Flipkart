package com.ecommerce.flipkart.exception;

public class APIException extends RuntimeException{

    public APIException(String message) {
       super(message);
    }
    public APIException(){


    }
}
