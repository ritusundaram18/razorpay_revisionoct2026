package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "merchant_webhook_config")
class MerchantWebhookConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "merchant_id",nullable = false)
    private Merchant merchant;

    @Column(nullable = false,length = 500)
    String targetUrl;
    @Column(length=255) String webhookSecretHash;

    @Column(nullable = false) Boolean enabled=true;
    @Column(length=255)
    private String eventTypes;
}
