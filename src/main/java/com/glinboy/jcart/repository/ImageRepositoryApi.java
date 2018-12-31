package com.glinboy.jcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.Image;

public interface ImageRepositoryApi extends JpaRepository<Image, Long> {
}
