package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepositoryApi extends JpaRepository<Discount, Long> {
}
