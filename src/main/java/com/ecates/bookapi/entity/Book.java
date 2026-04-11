package com.ecates.bookapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String authot;

    public Book() {
    }

    public Book(Long id, String name, String authot) {
        this.id = id;
        this.name = name;
        this.authot = authot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthot() {
        return authot;
    }

    public void setAuthot(String authot) {
        this.authot = authot;
    }
}
