package com.codingshuttle_revision_oct2026.razorpay_revision.common.exception;

public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;
    private final Object identifier;

    public ResourceNotFoundException(String resourceName, Object identifier) {
        super(resourceName+"not found"+identifier);
        this.resourceName = resourceName;
        this.identifier = identifier;

    }


}
