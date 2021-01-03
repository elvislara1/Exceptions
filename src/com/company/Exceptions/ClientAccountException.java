package com.company.Exceptions;

public class ClientAccountException extends Exception{
    public ClientAccountException(String message) {
        super(message);
    }

    public ClientAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientAccountException(Throwable cause){
        super(cause);
    }
}