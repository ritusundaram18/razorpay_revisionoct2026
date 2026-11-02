package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto;

import com.codingshuttle_revision_oct2026.razorpay_revision.common.enums.BusinessType;
import com.codingshuttle_revision_oct2026.razorpay_revision.common.enums.MerchantStatus;

import java.util.UUID;

public record MerchantResponse(

        UUID id,
        String name,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus merchantStatus

) {
}
