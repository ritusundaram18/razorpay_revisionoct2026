package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.entity;

import jakarta.persistence.*;
import org.hibernate.cfg.Environment;

import java.util.UUID;

@Entity
@Table(name = "api_key")
public class ApiKey {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(nullable = false, length = 50,unique = true)
    private String keyId;

    @Column(nullable = false, length = 200)
    private String keySecretHash;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Environment environment;

    @Column(nullable = false)
    private boolean enabled = true;
}
