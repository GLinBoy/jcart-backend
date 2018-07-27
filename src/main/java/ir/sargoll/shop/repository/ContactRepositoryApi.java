package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepositoryApi extends JpaRepository<Contact, Long> {
}
