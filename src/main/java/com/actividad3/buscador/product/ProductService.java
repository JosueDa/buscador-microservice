package com.actividad3.buscador.product;

import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RequestOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private static final String API_URL = "http://172.212.80.57:8080/products";
    private final RestTemplate restTemplate;

    public void updateProducts() {
        Iterable<Product> products = fetchProducts();
        for (Product product : products) {
            if (productRepository.existsById(product.getId())) {
                productRepository.save(product);
            } else {
                productRepository.save(product);
            }
        }
    }

    private Iterable<Product> fetchProducts() {
        Product[] productsArray = restTemplate.getForObject(API_URL, Product[].class);
        assert productsArray != null;
        return List.of(productsArray);
    }


    public Iterable<Product> searchProducts(String query) {
        return productRepository.findByTitleContainingOrDescriptionContaining(query,query);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
