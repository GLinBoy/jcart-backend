package com.glinboy.jcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.Contact;

public interface ContactRepositoryApi extends JpaRepository<Contact, Long> {
}
