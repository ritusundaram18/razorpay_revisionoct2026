package com.codingshuttle_revision_oct2026.razorpay_revision.common.exception;


import lombok.Getter;

@Getter
public class DuplicateResourceException extends RuntimeException{

    private final String errorCode;

    public DuplicateResourceException(String errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
