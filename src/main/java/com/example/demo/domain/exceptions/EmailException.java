package com.example.demo.domain.exceptions;

public class EmailException extends RuntimeException {
    private EmailException(String message) {
        super(message);
    }

    public static class EmailInvalidException extends EmailException {
        public EmailInvalidException(String email) {
            super("O email '" + email + "' é inválido.");
        }
    }
    public static class InvalidFormatException extends EmailException {
        public InvalidFormatException(String email) {
            super("O email '" + email + "' possui um formato inválido.");
        }
    }
}
