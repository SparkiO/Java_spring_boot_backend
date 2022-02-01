package com.oliver.reviews_backend.repository;

import com.oliver.reviews_backend.entity.Comment;
import com.oliver.reviews_backend.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findAllByReview(Review review);
}