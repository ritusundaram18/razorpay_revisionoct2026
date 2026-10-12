package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.entity;

import com.codingshuttle_revision_oct2026.razorpay_revision.common.enums.UserRole;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @ManyToOne(fetch=FetchType.LAZY)
    private Merchant merchant;

    @Column(unique = true,nullable = false)private String email;
   @Column(nullable = false) private String passwordHash;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false) UserRole role;


}
