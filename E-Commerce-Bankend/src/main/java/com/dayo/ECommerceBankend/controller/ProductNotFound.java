package com.dayo.ECommerceBankend.controller;

public class ProductNotFound extends RuntimeException{

    public ProductNotFound() {
        // TODO Auto-generated constructor stub
    }
    public ProductNotFound(String message) {
        super(message);
    }

}
