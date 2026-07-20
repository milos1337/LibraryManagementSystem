package com.milosh.lms.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {}

    public BookNotFoundException(String msg) {
        super(msg);
    }
}
