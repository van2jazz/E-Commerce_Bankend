package com.dayo.ECommerceBankend.exception;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(){}

    public CategoryNotFoundException(String message){
        super(message);
    }
}
