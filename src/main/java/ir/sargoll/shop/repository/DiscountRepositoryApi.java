package ir.sargoll.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.Discount;

public interface DiscountRepositoryApi extends JpaRepository<Discount, Long> {
}
