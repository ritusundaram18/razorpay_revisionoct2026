package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.controller;


import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.MerchantSignupRequest;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.dto.MerchantResponse;
import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MerchantResponse> signup(@RequestBody @Valid MerchantSignupRequest request ){

        return ResponseEntity.status(HttpStatus.CREATED).body(
                authService.signUp(request)
        );

    }

}
