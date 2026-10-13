package com.codingshuttle_revision_oct2026.razorpay_revision.vault.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="vault_card")
public class VaultCard {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable=false,length=4)
    private String lastFour;

    @Column(nullable = false,length=6)
    private String bin;//first 6 didgit

   @Column(nullable=false) private byte[] encryptedPan;
    @Column(nullable=false) private byte[] encryptedDek;

    @Column(nullable=false)  private String brand;//VISA RUPAY,MASTERCARD
    @Column(nullable=false)    private String expiryMonth;
    @Column(nullable=false)    private String expiryYear;
    @Column(nullable=false)  private String cardHolderName;
    private LocalDateTime deletedAt;




}
