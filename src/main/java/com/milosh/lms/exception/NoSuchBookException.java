package com.milosh.lms.exception;

public class NoSuchBookException extends RuntimeException {

    public NoSuchBookException() {}

    public NoSuchBookException(String msg) {
        super(msg);
    }
}
