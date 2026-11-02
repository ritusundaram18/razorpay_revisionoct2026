package com.codingshuttle_revision_oct2026.razorpay_revision.merchant.repopsitory;

import com.codingshuttle_revision_oct2026.razorpay_revision.merchant.entity.AppUser;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {


}
