package ir.sargoll.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import ir.sargoll.shop.model.Product;
import ir.sargoll.shop.service.ProductServiceApi;

@RestController
@RequestMapping(path = "/products")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class ProductController {

    @Autowired
    private ProductServiceApi productService;

    @GetMapping
    public Page<Product> getProducts(Pageable pageable) {
        return productService.getAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.getSingleById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping
    public Product updateProduct(Product product) {
        return productService.update(product);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteSingleById(productId);
    }
}
