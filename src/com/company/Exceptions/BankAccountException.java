package com.company.Exceptions;

public class BankAccountException extends Exception{
    public BankAccountException(String message) {
        super(message);
    }

    public BankAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankAccountException(Throwable cause) {
        super(cause);
    }
}