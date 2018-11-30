package ir.sargoll.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.Menu;

public interface MenuRepositoryApi extends JpaRepository<Menu, Long> {
}
