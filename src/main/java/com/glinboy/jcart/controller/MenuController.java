package com.glinboy.jcart.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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

}
