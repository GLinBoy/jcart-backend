package ir.sargoll.shop.controller;

import ir.sargoll.shop.model.Product;
import ir.sargoll.shop.service.ProductServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductServiceApi productService;

    @GetMapping
    public Page<Product> getProducts(Pageable pageable) {
        return productService.getAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getSingleById(id);
    }
}
