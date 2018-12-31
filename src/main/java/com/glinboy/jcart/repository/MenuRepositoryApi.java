package com.glinboy.jcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.Menu;

public interface MenuRepositoryApi extends JpaRepository<Menu, Long> {
}
