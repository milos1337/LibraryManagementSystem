package com.milosh.lms.exception;

public class BookAlreadyExistsException extends RuntimeException {

    public BookAlreadyExistsException() {}

    public BookAlreadyExistsException(String msg) {
        super(msg);
    }
}
