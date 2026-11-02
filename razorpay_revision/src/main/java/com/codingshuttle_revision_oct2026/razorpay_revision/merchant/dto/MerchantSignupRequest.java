package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto;

import com.codingshuttle_revision_oct2026.razorpay_revision.common.enums.BusinessType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MerchantSignupRequest(

        @NotNull(message="Name is  required")
        @Size(max=50,message="Name should not exceed 50 characters")
        String name,
        @Email
        @NotNull(message = "Email is required")
        String email,
        @NotNull(message = "password is required")
        @Size(max=8,message="password should be at least 8 characters")
        String password,

        @Size(max=50,message="businessName should not be more than 50 characters")
        String businessName,
        BusinessType businessType

) {
}
