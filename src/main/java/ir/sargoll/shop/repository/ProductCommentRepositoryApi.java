package ir.sargoll.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.ProductComment;

public interface ProductCommentRepositoryApi extends JpaRepository<ProductComment, Long> {
}
