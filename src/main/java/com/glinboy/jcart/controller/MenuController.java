package com.glinboy.jcart.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.model.Menu;
import com.glinboy.jcart.service.MenuServiceApi;
import com.glinboy.jcart.service.dto.MenuDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/menus")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class MenuController {

	private final MenuServiceApi menuService;

	@GetMapping
	public Page<MenuDTO> getAllMenus(Pageable pageable) {
		return menuService.getAll(pageable);
	}

	@GetMapping(path = "/{id}")
	public MenuDTO getMenuById(@PathVariable Long id) {
		return menuService.getSingleById(id);
	}

	@PostMapping
	public MenuDTO saveMenu(@RequestBody MenuDTO menuDTO) {
		return menuService.save(menuDTO);
	}

	@PutMapping
	public Menu updateMenu(@RequestBody Menu menu) {
		return menuService.update(menu);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteMenu(@PathVariable Long id) {
		menuService.deleteSingleById(id);
	}
}
