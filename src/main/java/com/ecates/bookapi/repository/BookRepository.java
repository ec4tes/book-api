package com.ecates.bookapi.repository;

import com.ecates.bookapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByNameContainingIgnoreCase(String name);

    List<Book> findByAuthor_NameContainingIgnoreCase(String author);

    Optional<Book> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

    List<Book> findByNameContainingIgnoreCaseAndAuthor_NameContainingIgnoreCase(String name, String author);
}