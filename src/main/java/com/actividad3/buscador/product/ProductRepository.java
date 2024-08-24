package com.actividad3.buscador.product;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product,Integer> {
    List<Product> findByTitleContainingOrDescriptionContaining(String title, String description);
}
