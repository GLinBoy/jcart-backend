package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponRepositoryApi extends JpaRepository<Coupon, Long> {
    Optional<Coupon> findByCode(String code);
}
