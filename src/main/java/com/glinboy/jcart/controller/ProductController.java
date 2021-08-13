package com.glinboy.jcart.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.service.ProductServiceApi;
import com.glinboy.jcart.service.dto.ProductShopItemDTO;

@RestController
@RequestMapping(path = "/products")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class ProductController extends GenericController<ProductShopItemDTO, ProductServiceApi> {

	public ProductController(ProductServiceApi service) {
		super(service);
	}
}
