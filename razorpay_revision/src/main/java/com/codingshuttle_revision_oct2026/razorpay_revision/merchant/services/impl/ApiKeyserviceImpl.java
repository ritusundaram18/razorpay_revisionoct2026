package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.services.impl;

import com.codingshuttle_revision_oct2026.razorpay_revision.common.exception.ResourceNotFoundException;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.request.CreateApiKeyRequest;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.response.ApiKeyCreateResponse;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.entity.ApiKey;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.entity.Merchant;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.repopsitory.ApiKeyRepository;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.repopsitory.MerchantRepository;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.services.ApiKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiKeyserviceImpl implements ApiKeyService {


    private final MerchantRepository merchantRepository;

    private final ApiKeyRepository apiKeyRepository;
    @Override
    public ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request) {
        Merchant merchant= merchantRepository
                .findById(merchantId).orElseThrow(() -> new ResourceNotFoundException("merchant", merchantId));

        String keyId="rzp_"+request.environment().name().toLowerCase()+"big_random"+UUID.randomUUID();

        String rawSecret="big_random_secret";//TODO:replace with cryptography

        ApiKey apiKey=ApiKey.builder()
                .merchant(merchant)
                .keyId(keyId)
                .keySecretHash(rawSecret)//TODO:encrypt with Bcrypt
                .environment(request.environment())
                .build();
        apiKey=apiKeyRepository.save(apiKey);


        return new ApiKeyCreateResponse(apiKey.getId(), keyId, rawSecret, request.environment());
    }
}
