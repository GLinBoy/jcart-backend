package ir.sargoll.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.Content;

public interface ContentRepositoryApi extends JpaRepository<Content, Long> {
    Optional<Content> findByTitle(String title);
}
