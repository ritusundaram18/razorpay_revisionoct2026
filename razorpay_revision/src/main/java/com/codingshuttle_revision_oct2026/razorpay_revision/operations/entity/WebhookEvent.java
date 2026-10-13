package com.codingshuttle_revision_oct2026.razorpay_revision.operations.entity;


import com.codingshuttle_revision_oct2026.razorpay_revision.common.enums.WebhookEventStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "webhook_event")

public class WebhookEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(nullable = false)
    private UUID merchantId;
    @Column(nullable = false,length = 100)
    private String eventType;


    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private Map<String,Object> payload;
    @Column(nullable = false)
    private String targetUrl;

    @Column(nullable = false)private String signature;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false) WebhookEventStatus status;

    @Column(nullable = false)
    private Integer attempts;

    private LocalDateTime nextRetryAt;

    private LocalDateTime lastAttemptAt;

    private Integer lastResponseCode;

    private String lastResponseBody;

    private LocalDateTime deliveredAt;





}
