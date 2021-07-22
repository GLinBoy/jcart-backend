package com.glinboy.jcart.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.model.Content;
import com.glinboy.jcart.service.ContentServiceApi;
import com.glinboy.jcart.service.dto.ContentDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/contents")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class ContentController {

	private final ContentServiceApi contentService;

	@GetMapping(path = "/{id}")
	public ContentDTO getContentById(@PathVariable Long id) {
		return contentService.getSingleById(id);
	}

	@GetMapping(path = "/{title}")
	public ContentDTO getContentById(@PathVariable String title) {
		return contentService.getSingleByTitle(title);
	}

	@PostMapping
	public ContentDTO saveContent(@RequestBody ContentDTO contentDTO) {
		return contentService.save(contentDTO);
	}

	@PutMapping
	public Content updateContent(@RequestBody Content content) {
		return contentService.update(content);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteContent(@PathVariable Long id) {
		contentService.deleteSingleById(id);
	}
}
