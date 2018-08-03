package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepositoryApi extends JpaRepository<Content, Long> {
}
