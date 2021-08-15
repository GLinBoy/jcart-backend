package com.glinboy.jcart.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.glinboy.jcart.service.MenuServiceApi;
import com.glinboy.jcart.service.dto.MenuDTO;

@RestController
@RequestMapping(path = "/menus")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class MenuController extends GenericController<MenuDTO, MenuServiceApi> {

	public MenuController(MenuServiceApi service) {
		super(service);
	}

	@GetMapping
	public ResponseEntity<Page<MenuDTO>> getAllMenus(Pageable pageable) {
		return ResponseEntity.ok(this.service.getAll(pageable));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<MenuDTO> getMenuById(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getSingleById(id));
	}

	@PostMapping
	public ResponseEntity<MenuDTO> saveMenu(@RequestBody MenuDTO menuDTO) {
		return ResponseEntity.ok(this.service.save(menuDTO));
	}

	@PutMapping
	public ResponseEntity<MenuDTO> updateMenu(@RequestBody MenuDTO menuDTO) {
		return ResponseEntity.ok(this.service.update(menuDTO));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
		this.service.deleteSingleById(id);
		return ResponseEntity.ok().build();
	}
}
