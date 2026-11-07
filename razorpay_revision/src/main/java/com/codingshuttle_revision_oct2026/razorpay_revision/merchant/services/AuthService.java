package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.services;

import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.response.MerchantResponse;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.request.MerchantSignupRequest;

public interface AuthService {

    MerchantResponse signUp(MerchantSignupRequest request);
}
