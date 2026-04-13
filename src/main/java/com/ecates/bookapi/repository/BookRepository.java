package com.ecates.bookapi.repository;

import com.ecates.bookapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByNameContainingIgnoreCase(String name); // isme gore icinde gecen ifadeyi bulur

    List<Book> findByAuthorContainingIgnoreCase(String author);// yazara gore icinde gecen ifadeyi bulur

    Optional<Book> findByNameIgnoreCase(String name);// tam ismiyle kitabi bulur

    boolean existsByNameIgnoreCase(String name);// bu islem kitap vr mi diye kontrol eder

    List<Book> findByNameContainingIgnoreCaseAndAuthorContainsIgnoreCase(String name, String author);// isim ve yazara gore birlikte arama yapar



}
