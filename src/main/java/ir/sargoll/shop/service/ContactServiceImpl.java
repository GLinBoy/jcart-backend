package ir.sargoll.shop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ir.sargoll.shop.model.Contact;
import ir.sargoll.shop.repository.ContactRepositoryApi;

@Service
@Transactional
public class ContactServiceImpl extends AbstractServiceImpl<Contact, ContactRepositoryApi> implements ContactServiceApi {
}
