package com.glinboy.jcart.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.model.Contact;
import com.glinboy.jcart.service.ContactServiceApi;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/contact")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class ContactController {
	
	private final ContactServiceApi contactService;

	@GetMapping
	public Contact getContact(Pageable pageable) {
		return contactService.getAll(pageable).getContent().get(0);
	}

	@PutMapping
	public Contact updateContact(@RequestBody Contact contact) {
		return contactService.update(contact);
	}
}
