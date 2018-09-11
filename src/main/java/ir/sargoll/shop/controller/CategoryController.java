package ir.sargoll.shop.controller;

import ir.sargoll.shop.model.Product;
import ir.sargoll.shop.model.ProductCategory;
import ir.sargoll.shop.service.ProductCategoryServiceApi;
import ir.sargoll.shop.service.ProductServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    @Autowired
    private ProductCategoryServiceApi categoryService;

    @Autowired
    private ProductServiceApi productService;

    @GetMapping
    public Page<ProductCategory> getCategories(Pageable pageable) {
        return categoryService.getAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public ProductCategory getCategory(@PathVariable Long id) {
        return categoryService.getSingleById(id);
    }

    @PostMapping
    public ProductCategory addCategory(@RequestBody ProductCategory category) {
        return categoryService.save(category);
    }

    @PutMapping
    public ProductCategory updateCategory(@RequestBody ProductCategory category) {
        return categoryService.update(category);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteSingleById(id);
    }

    @GetMapping(path = "/{id}/products")
    public Page<Product> getProducts(@PathVariable Long id, Pageable pageable) {
        return productService.getProductsCategory(id, pageable);
    }

    @GetMapping(path = "/{parentId}/childes")
    public Page<ProductCategory> getChildes(@PathVariable("parentId") Long parentId, Pageable pageable) {
        return categoryService.getChildMenu(parentId, pageable);
    }
}
