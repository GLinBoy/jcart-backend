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

import com.glinboy.jcart.service.ProductServiceApi;
import com.glinboy.jcart.service.dto.ProductDTO;
import com.glinboy.jcart.service.dto.ProductShopItemDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/products")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class ProductController {

	private final ProductServiceApi productService;

	@GetMapping
	public ResponseEntity<Page<ProductShopItemDTO>> getProducts(Pageable pageable) {
		return ResponseEntity.ok(productService.getAll(pageable));
	}

	@GetMapping(path = "/{id}")
	public ProductDTO getProduct(@PathVariable("id") Long id) {
		return productService.getSingleById(id);
	}

	@PostMapping
	public ProductDTO addProduct(@RequestBody ProductShopItemDTO productDTO) {
		return productService.save(productDTO);
	}

	@PutMapping
	public ProductDTO updateProduct(ProductShopItemDTO productDTO) {
		return productService.update(productDTO);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteProduct(@PathVariable("id") Long productId) {
		productService.deleteSingleById(productId);
	}
}
