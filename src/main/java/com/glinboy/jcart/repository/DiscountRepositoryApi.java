package com.glinboy.jcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.Discount;

public interface DiscountRepositoryApi extends JpaRepository<Discount, Long> {
}
