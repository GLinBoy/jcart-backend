package com.glinboy.jcart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.Coupon;

public interface CouponRepositoryApi extends JpaRepository<Coupon, Long> {
    Optional<Coupon> findByCode(String code);
}
