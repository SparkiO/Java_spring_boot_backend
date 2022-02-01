package com.oliver.reviews_backend.controller;

import com.oliver.reviews_backend.entity.Review;
import com.oliver.reviews_backend.repository.ProductRepository;
import com.oliver.reviews_backend.repository.ReviewRepository;
import com.oliver.reviews_backend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewController {

    final private ReviewRepository reviewRepository;
    final private ProductRepository productRepository;

    @Autowired
    public ReviewController(final ReviewRepository reviewRepository, final ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    /**
     * Creates a review for a product.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @PostMapping("/reviews/products/{productId}")
    public ResponseEntity<?> createReview(@RequestBody Review review, @PathVariable int productId)
    {
        Optional<Product> resource = productRepository.findById(productId);
        if(resource.isPresent()){
            review.setProduct(resource.get());
            reviewRepository.save(review);
            return ResponseEntity.ok(reviewRepository.save(review));
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Lists reviews by product.
     */
    @GetMapping("/reviews/products/{productId}")
    public ResponseEntity<?> getReviews(@PathVariable int productId)
    {
        return ResponseEntity.ok(reviewRepository.findAllByProduct(new Product(productId)));
    }
}