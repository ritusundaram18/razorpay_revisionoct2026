package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.entity;

import com.codingshuttle_revision_oct2026.razorpay_revision.operations.entity.WebhookEvent;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "dlq_event")
public class DlqEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID merchantId;

    @OneToOne(fetch = FetchType.LAZY)
    private WebhookEvent webhookEvent;
    @Column(length=1000) String finalError;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(nullable = false,columnDefinition = "jsonb") Map<String,Object> payload;

}
