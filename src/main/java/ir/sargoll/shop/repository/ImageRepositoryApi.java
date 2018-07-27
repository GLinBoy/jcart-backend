package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepositoryApi extends JpaRepository<Image, Long> {
}
