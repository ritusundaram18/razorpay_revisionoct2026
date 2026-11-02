package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.repopsitory;

import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.entity.Merchant;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MerchantRepository extends JpaRepository<Merchant, UUID> {
    boolean existsByemail(String email);
}
