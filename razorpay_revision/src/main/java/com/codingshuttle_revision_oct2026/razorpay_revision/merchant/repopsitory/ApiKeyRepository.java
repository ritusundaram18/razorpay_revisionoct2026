package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.repopsitory;

import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApiKeyRepository extends JpaRepository<ApiKey, UUID> {
}
