package com.glinboy.jcart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.service.ContentServiceApi;
import com.glinboy.jcart.service.dto.ContentDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(path = "/contents")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@SecurityRequirement(name = "Bearer Authentication")
public class ContentController extends GenericController<ContentDTO, ContentServiceApi> {

	public ContentController(ContentServiceApi service) {
		super(service);
	}

	@GetMapping(path = "/{title}")
	public ResponseEntity<ContentDTO> getContentById(@PathVariable String title) {
		return ResponseEntity.ok(this.service.getSingleByTitle(title));
	}
}
