package com.glinboy.jcart.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Contact;
import com.glinboy.jcart.repository.ContactRepositoryApi;

@Service
@Transactional
public class ContactServiceImpl extends AbstractServiceImpl<Contact, ContactRepositoryApi> implements ContactServiceApi {
}
