package com.glinboy.jcart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.service.ContentServiceApi;
import com.glinboy.jcart.service.dto.ContentDTO;

@RestController
@RequestMapping(path = "/contents")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class ContentController extends GenericController<ContentDTO, ContentServiceApi> {

	public ContentController(ContentServiceApi service) {
		super(service);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<ContentDTO> getContentById(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getSingleById(id));
	}

	@GetMapping(path = "/{title}")
	public ResponseEntity<ContentDTO> getContentById(@PathVariable String title) {
		return ResponseEntity.ok(this.service.getSingleByTitle(title));
	}

	@PostMapping
	public ResponseEntity<ContentDTO> saveContent(@RequestBody ContentDTO contentDTO) {
		return ResponseEntity.ok(this.service.save(contentDTO));
	}

	@PutMapping
	public ResponseEntity<ContentDTO> updateContent(@RequestBody ContentDTO contentDTO) {
		return ResponseEntity.ok(this.service.update(contentDTO));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
		this.service.deleteSingleById(id);
		return ResponseEntity.ok().build();
	}
}
