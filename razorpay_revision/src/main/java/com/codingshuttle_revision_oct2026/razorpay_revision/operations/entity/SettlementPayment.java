package com.codingshuttle_revision_oct2026.razorpay_revision.operations.entity;

import jakarta.persistence.*;

@Entity
@Table(name="settlement_payment")
public class SettlementPayment {
    @EmbeddedId
    private SettlementPaymentId id;

    @MapsId()
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "settlement_id",nullable = false)
    private Settlement settlement;



}
