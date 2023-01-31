package com.example.diary.exception;

public class PasswordMisMatchException extends UserException {
    public PasswordMisMatchException(String message) {
        super(message);
    }
}
