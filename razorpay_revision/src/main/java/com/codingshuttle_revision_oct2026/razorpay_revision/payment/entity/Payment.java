package com.codingshuttle_revision_oct2026.razorpay_revision.payment.entity;

import com.codingshuttle_revision_oct2026.razorpay_revision.common.entity.Money;
import com.codingshuttle_revision_oct2026.razorpay_revision.common.enums.PaymentMethod;
import com.codingshuttle_revision_oct2026.razorpay_revision.common.enums.PaymentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;

    @Embedded
    private Money amount;

   @ManyToOne(fetch=FetchType.LAZY,optional = false)
   @JoinColumn(name = "order_id",nullable = false)
   private OrderRecord order;

    @Column(nullable = false)
    UUID merchantId;
   @Column(nullable=false,length=100)
   private String idempotencyKey;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length=30) PaymentStatus status;

    @Column(nullable=false) PaymentMethod method;

    @Column(name = "method_details",columnDefinition = "jsonb")
    private Map<String, Object> methodDetails;

    @Column(length = 100)
    private String bankReference;
    @Column(length = 100)
    private String errorCode;

    @Column(length = 100)
    private String errorDescription;

    private LocalDateTime authorizedAt;

    private LocalDateTime captureddAt;

    private LocalDateTime failedAt;

    private LocalDateTime refundedAt;


}
