package com.milosh.lms.exception;

public class IncorrectPasswordException extends RuntimeException {

    public IncorrectPasswordException() {}

    public IncorrectPasswordException(String msg) {
        super(msg);
    }
}
