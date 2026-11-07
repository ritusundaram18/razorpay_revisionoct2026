package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.services;

import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.request.CreateApiKeyRequest;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.response.ApiKeyCreateResponse;

import java.util.UUID;

public interface ApiKeyService {

    ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request);
}
