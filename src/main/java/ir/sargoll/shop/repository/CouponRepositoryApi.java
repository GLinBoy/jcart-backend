package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepositoryApi extends JpaRepository<Coupon, Long> {
}
