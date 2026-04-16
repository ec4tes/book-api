package com.ecates.bookapi.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@SuperBuilder
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Table(name = "books")
public class Book extends BaseEntity{

    private String name;
    private String isbn;
    private Integer pageCount;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
