package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Contact;
import com.glinboy.jcart.repository.ContactRepositoryApi;
import com.glinboy.jcart.service.ContactServiceApi;
import com.glinboy.jcart.service.dto.ContactDTO;
import com.glinboy.jcart.service.mapper.ContactMapper;

@Service
@Transactional
public class ContactServiceImpl extends AbstractServiceImpl<ContactDTO, Contact, ContactMapper, ContactRepositoryApi> implements ContactServiceApi {

	public ContactServiceImpl(ContactRepositoryApi repository, ContactMapper mapper) {
		super(repository, mapper);
	}
}
