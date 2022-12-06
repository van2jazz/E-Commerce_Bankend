package com.dayo.ECommerceBankend.exception;

public class SellerNotFoundException extends RuntimeException{

    public SellerNotFoundException(){ super();}

    public SellerNotFoundException(String message) { super(message);}

}
