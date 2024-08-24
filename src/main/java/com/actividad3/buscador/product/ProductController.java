package com.actividad3.buscador.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/searches")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/productsByQuery")
    public Iterable<Product> searchProducts(@RequestParam String query) {
        return productService.searchProducts(query);
    }

    @GetMapping("/products")
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/update")
    public void updateProducts() {
        productService.updateProducts();
    }
}
