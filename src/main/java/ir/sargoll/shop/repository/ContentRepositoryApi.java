package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentRepositoryApi extends JpaRepository<Content, Long> {
    Optional<Content> findByTitle(String title);
}
