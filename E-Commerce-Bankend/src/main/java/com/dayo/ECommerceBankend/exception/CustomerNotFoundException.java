package com.dayo.ECommerceBankend.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(){ super();}

    public CustomerNotFoundException(String message){ super(message);
    }
}
