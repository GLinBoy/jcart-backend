package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCommentRepositoryApi extends JpaRepository<ProductComment, Long> {
}
