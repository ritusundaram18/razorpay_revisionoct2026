package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.controller;

import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.request.CreateApiKeyRequest;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.response.ApiKeyCreateResponse;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.services.ApiKeyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/merchants/{merchantId}/api-keys")
@RequiredArgsConstructor
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    @PostMapping
    public ResponseEntity<ApiKeyCreateResponse> create(@PathVariable UUID merchantId,
                                                       @Valid @RequestBody CreateApiKeyRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(apiKeyService.create(merchantId, request));

    }

}
