package com.glinboy.jcart.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.service.ProductCategoryServiceApi;
import com.glinboy.jcart.service.ProductServiceApi;
import com.glinboy.jcart.service.dto.ProductCategoryDTO;
import com.glinboy.jcart.service.dto.ProductShopItemDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(path = "/categories")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@SecurityRequirement(name = "Bearer Authentication")
public class CategoryController extends GenericController<ProductCategoryDTO, ProductCategoryServiceApi> {

	private final ProductServiceApi productService;

	public CategoryController(ProductCategoryServiceApi service,
			ProductServiceApi productService) {
		super(service);
		this.productService = productService;
	}

	@GetMapping(path = "/{id}/products")
	public ResponseEntity<Page<ProductShopItemDTO>> getProducts(@PathVariable Long id, Pageable pageable) {
		return ResponseEntity.ok(productService.getProductsCategory(id, pageable));
	}

	@GetMapping(path = "/{parentId}/childes")
	public ResponseEntity<Page<ProductCategoryDTO>> getChildes(@PathVariable("parentId") Long parentId, Pageable pageable) {
		return ResponseEntity.ok(this.service.getChildMenu(parentId, pageable));
	}
}
