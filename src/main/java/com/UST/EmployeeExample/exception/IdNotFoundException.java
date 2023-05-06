package com.UST.EmployeeExample.exception;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String noId) {
        super(noId);
    }
}
