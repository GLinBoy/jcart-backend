package ir.sargoll.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.Contact;

public interface ContactRepositoryApi extends JpaRepository<Contact, Long> {
}
