package com.milosh.lms.exception;

public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException() {}

    public NoSuchUserException(String msg) {
        super(msg);
    }
}
