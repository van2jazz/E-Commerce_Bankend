package com.dayo.ECommerceBankend.exception;

public class ProductNotFound extends RuntimeException {

    public ProductNotFound() {

    }
    public ProductNotFound(String message) {
        super(message);
    }
}
