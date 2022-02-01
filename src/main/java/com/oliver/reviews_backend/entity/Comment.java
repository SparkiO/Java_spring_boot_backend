package com.oliver.reviews_backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Comment text cannot be empty")
    private String content;

    @ManyToOne
    private Review review;

    public Comment() {

    }

    public Comment(Review review, int id, String content) {
        this.review = review;
        this.id = id;
        this.content = content;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

