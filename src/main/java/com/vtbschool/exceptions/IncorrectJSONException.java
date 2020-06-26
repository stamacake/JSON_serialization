package com.vtbschool.exceptions;

public class IncorrectJSONException extends SerializationLibException {
    public IncorrectJSONException() {
    }

    public IncorrectJSONException(String message) {
        super(message);
    }
}
