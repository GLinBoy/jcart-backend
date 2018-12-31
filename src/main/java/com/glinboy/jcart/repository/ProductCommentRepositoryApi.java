package com.glinboy.jcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.ProductComment;

public interface ProductCommentRepositoryApi extends JpaRepository<ProductComment, Long> {
}
