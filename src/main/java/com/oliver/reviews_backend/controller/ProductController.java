package com.oliver.reviews_backend.controller;

import com.oliver.reviews_backend.repository.ProductRepository;
import com.oliver.reviews_backend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Spring REST controller for working with product entity.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(final ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    /**
     * Creates a product.
     */
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    /**
     * Finds a product by id.
     *
     * @param id The id of the product.
     * @return The product if found, or a 404 not found.
     */
    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }


    /**
     * Lists all products.
     *
     * @return The list of products.
     */
    @GetMapping(value = "/")
    public ResponseEntity<Iterable<Product>> listProducts() {
        return ResponseEntity.of(Optional.of(productRepository.findAll()));

    }
}