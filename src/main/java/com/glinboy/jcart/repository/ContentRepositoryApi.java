package com.glinboy.jcart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.Content;

public interface ContentRepositoryApi extends JpaRepository<Content, Long> {
    Optional<Content> findByTitle(String title);
}
