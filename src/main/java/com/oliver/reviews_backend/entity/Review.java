package com.oliver.reviews_backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Content cannot be empty")
    private String content;

    @ManyToOne
    private Product product;

    public Review(){

    }
    public Review(Integer id) {
        this.id = id;
    }

    public Review(String content){
        this.content = content;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String reviewText) {
        this.content = reviewText;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
