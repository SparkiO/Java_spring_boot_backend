package com.oliver.reviews_backend.repository;

import com.oliver.reviews_backend.entity.Product;
import com.oliver.reviews_backend.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findAllByProduct(Product product);
}
