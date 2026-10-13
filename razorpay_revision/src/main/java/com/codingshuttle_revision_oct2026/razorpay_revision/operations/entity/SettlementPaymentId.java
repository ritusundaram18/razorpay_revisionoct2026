package com.codingshuttle_revision_oct2026.razorpay_revision.operations.entity;


import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class SettlementPaymentId {
    private UUID settlementId;
    private UUID paymentId;
}
