package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.services.impl;

import com.codingshuttle_revision_oct2026.razorpay_revision.common.enums.MerchantStatus;
import com.codingshuttle_revision_oct2026.razorpay_revision.common.enums.UserRole;
import com.codingshuttle_revision_oct2026.razorpay_revision.common.exception.DuplicateResourceException;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.response.MerchantResponse;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.request.MerchantSignupRequest;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.entity.AppUser;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.entity.Merchant;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.repopsitory.AppUserRepository;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.repopsitory.MerchantRepository;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.services.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j

public class AuthServiceImpl implements AuthService {

    private final AppUserRepository appUserRepository;
    private final MerchantRepository merchantRepository;


    @Override
    public MerchantResponse signUp(MerchantSignupRequest request) {

        if(merchantRepository.existsByemail(request.email())){
            throw new DuplicateResourceException("DUPLICATE_MERCHANT_EMAIL",
                    "Merchant with email already exists:" + request.email() );
        }

        Merchant merchant= Merchant.builder().businessName(request.businessName())
                .businessType(request.businessType())
                .name(request.name())
                .email(request.email()).
        status(MerchantStatus.PENDING_KYC).
                build();

        merchant=merchantRepository.save(merchant);

        AppUser appUser=AppUser.builder()
                .email(request.email())
                .merchant(merchant)
                .passwordHash(request.password())//TODO encrypt using bcrypt
                .role(UserRole.OWNER)
                .build();
        appUserRepository.save(appUser);


        return new MerchantResponse(merchant.getId(), merchant.getName(),
                merchant.getEmail(),merchant.getBusinessName(),merchant.getBusinessType(),merchant.getStatus());
   }
}
