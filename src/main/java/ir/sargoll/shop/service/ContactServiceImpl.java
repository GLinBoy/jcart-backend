package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Contact;
import ir.sargoll.shop.repository.ContactRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ContactServiceImpl extends AbstractServiceImpl<Contact, ContactRepositoryApi> implements ContactServiceApi {
}
