package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.response;

import com.codingshuttle_revision_oct2026.razorpay_revision.common.enums.Environment;

import java.util.UUID;

public record ApiKeyCreateResponse(
        UUID id,
        String keyId,
        String keySecret,
        Environment environment



) {
}
