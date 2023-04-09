package com.glinboy.jcart.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.glinboy.jcart.service.GenericService;
import com.glinboy.jcart.service.dto.BaseDTO;
import com.glinboy.jcart.util.PaginationUtil;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public abstract class GenericController<T extends BaseDTO, S extends GenericService<T>> {

	protected final ResourceBundle messages = PropertyResourceBundle.getBundle("i18n/messages");

	protected final S service;

	@GetMapping
	@PageableAsQueryParam
	public ResponseEntity<List<T>> getAll(@Parameter(hidden = true) Pageable pageable, HttpServletRequest request) {
		Page<T> page = service.getAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, request.getRequestURI());
		headers.setAccessControlExposeHeaders(Arrays.asList(HttpHeaders.LINK, "X-Total-Count"));
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> getById(@PathVariable Long id) {
		T entity = service.getSingleById(id);
		return ResponseEntity.ok().body(entity);
	}

	@PostMapping
	public ResponseEntity<T> save(@Valid @RequestBody T entity, HttpServletRequest request) {
		T savedEntity = service.save(entity);
		URI location = URI.create(String.format("%s/%s", request.getRequestURI(), savedEntity.getId()));
		return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).body(savedEntity);
	}

	@PutMapping
	public ResponseEntity<T> update(@Valid @RequestBody T entity) {
		if (entity.getId() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, messages.getString("common.error.empty.id"));
		}
		T updatedEntity = service.update(entity);
		return ResponseEntity.ok().body(updatedEntity);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteSingleById(id);
		return ResponseEntity.noContent().build();
	}

}
