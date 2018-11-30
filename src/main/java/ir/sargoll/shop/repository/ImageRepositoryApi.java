package ir.sargoll.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.Image;

public interface ImageRepositoryApi extends JpaRepository<Image, Long> {
}
