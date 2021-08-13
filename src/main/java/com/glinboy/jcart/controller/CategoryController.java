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

import com.glinboy.jcart.service.ProductCategoryServiceApi;
import com.glinboy.jcart.service.ProductServiceApi;
import com.glinboy.jcart.service.dto.ProductCategoryDTO;
import com.glinboy.jcart.service.dto.ProductShopItemDTO;

@RestController
@RequestMapping(path = "/categories")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class CategoryController extends GenericController<ProductCategoryDTO, ProductCategoryServiceApi> {

	private final ProductServiceApi productService;

	public CategoryController(ProductCategoryServiceApi service,
			ProductServiceApi productService) {
		super(service);
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<Page<ProductCategoryDTO>> getCategories(Pageable pageable) {
		return ResponseEntity.ok(this.service.getAll(pageable));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<ProductCategoryDTO> getCategory(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getSingleById(id));
	}

	@PostMapping
	public ResponseEntity<ProductCategoryDTO> addCategory(@RequestBody ProductCategoryDTO category) {
		return ResponseEntity.ok(this.service.save(category));
	}

	@PutMapping
	public ResponseEntity<ProductCategoryDTO> updateCategory(@RequestBody ProductCategoryDTO category) {
		return ResponseEntity.ok(this.service.update(category));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		this.service.deleteSingleById(id);
		return ResponseEntity.ok().build();
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
