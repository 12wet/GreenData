package com.greendata.exceptions;

public class InvestorNotFoundException extends RuntimeException {

    public InvestorNotFoundException(Long id){
        super("Could not find employee of id: " + id);
    }
}
