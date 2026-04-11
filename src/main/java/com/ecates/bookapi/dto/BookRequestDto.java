package com.ecates.bookapi.dto;

import lombok.Builder;

@Builder
public class BookRequestDto {

    private String name;
    private String author;

    public BookRequestDto() {
    }

    public BookRequestDto(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
