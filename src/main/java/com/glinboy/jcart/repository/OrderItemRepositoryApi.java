package com.glinboy.jcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.ProductOrderItem;

public interface OrderItemRepositoryApi extends JpaRepository<ProductOrderItem, Long> {
}
