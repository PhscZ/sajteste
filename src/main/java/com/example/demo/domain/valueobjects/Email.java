package com.example.demo.domain.valueobjects;

import java.util.regex.Pattern;

import com.example.demo.domain.exceptions.EmailException;

import lombok.Value;

@Value
public class Email {
    String address;
    private static final Pattern GENERAL_EMAIL_FORM_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    
    public Email(String address) {
        String validatedAddress = requireNonBlank(address, new EmailException.EmailInvalidException(address));

        String normalizedAddress = validatedAddress.trim().toLowerCase();

        this.address = normalizedAddress;
    }

    public void validateFormat(String address) {
        if (!GENERAL_EMAIL_FORM_PATTERN.matcher(address).matches()) {
            throw new EmailException.InvalidFormatException(address);
        }
    }

    @Override
    public String toString() {
        return this.address;
    }

    //não era pra estar aqui mas vai ficar aqui
    public static boolean isNullOrBlank(String string) {
        return (string == null || string.isBlank());
    }

    public static String requireNonBlank(String string, RuntimeException exception) {
        if (isNullOrBlank(string)) {
            throw exception;
        }
        return string;
    }
}
