package com.oliver.reviews_backend.controller;

import com.oliver.reviews_backend.entity.Comment;
import com.oliver.reviews_backend.entity.Review;
import com.oliver.reviews_backend.repository.CommentRepository;
import com.oliver.reviews_backend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentController {


    private final CommentRepository commentRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public CommentController(final CommentRepository commentRepository, final ReviewRepository reviewRepository) {
        this.commentRepository = commentRepository;
        this.reviewRepository = reviewRepository;
    }

    /**
     * Creates a comment for a review.
     * @param reviewId The id of the review.
     */
    @PostMapping("/reviews/{reviewId}")
    public ResponseEntity<?> createCommentForReview(@RequestBody final Comment comment, @PathVariable("reviewId") final int reviewId) {
        Optional<Review> reviewResource = reviewRepository.findById(reviewId);
        if (reviewResource.isPresent()) {
            comment.setReview(reviewResource.get());
            return ResponseEntity.ok(commentRepository.save(comment));
        }
        return ResponseEntity.ok().build();
    }

    /**
     * List comments for a review.
     * @param reviewId The id of the review.
     */
    @GetMapping(value = "/reviews/{reviewId}")
    public ResponseEntity<?> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (review.isPresent()) {
            return ResponseEntity.ok(commentRepository.findAllByReview(new Review(reviewId)));
        }
        return ResponseEntity.notFound().build();
    }
}
