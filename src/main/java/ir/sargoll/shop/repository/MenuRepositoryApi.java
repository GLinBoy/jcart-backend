package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepositoryApi extends JpaRepository<Menu, Long> {
}
