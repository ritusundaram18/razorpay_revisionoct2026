package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.entity;

import com.codingshuttle_revision_oct2026.razorpay_revision.common.enums.BusinessType;
import com.codingshuttle_revision_oct2026.razorpay_revision.common.enums.MerchantStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="merchants")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor@Builder
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false,length=200)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;

    @Column(length=20)
    String contactNumber;
    @Column(length=50)
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    @Column(length=100)private  String  businessName;
    @Column(length=200)private String websiteUrl;

    @Column(length=200,nullable = false)
    private MerchantStatus status=MerchantStatus.PENDING_KYC;

    @Column(length=20)
    private String gstId;
    @Column(length=20)
    private String panId;

    @Column(length=200)
    private String settlementBankAccount;
    private String settlementBankIfsc;
    private String settlementBankHolderName;


}
