package ir.sargoll.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.Coupon;

public interface CouponRepositoryApi extends JpaRepository<Coupon, Long> {
    Optional<Coupon> findByCode(String code);
}
