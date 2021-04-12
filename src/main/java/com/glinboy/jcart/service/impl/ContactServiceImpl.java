package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Contact;
import com.glinboy.jcart.repository.ContactRepositoryApi;
import com.glinboy.jcart.service.ContactServiceApi;

@Service
@Transactional
public class ContactServiceImpl extends AbstractServiceImpl<Contact, ContactRepositoryApi> implements ContactServiceApi {

	public ContactServiceImpl(ContactRepositoryApi repository) {
		super(repository);
	}
}
