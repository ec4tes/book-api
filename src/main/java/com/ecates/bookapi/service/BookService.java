package com.ecates.bookapi.service;

import com.ecates.bookapi.dto.request.BookRequestDto;
import com.ecates.bookapi.dto.response.BookResponseDto;
import com.ecates.bookapi.entity.Author;

import java.util.List;

public interface BookService {
    List<BookResponseDto> getAllBooks();

    BookResponseDto getBookById(Long id);

    BookResponseDto addBook(BookRequestDto bookRequestDto);

    void deleteBook(Long id);

    List<BookResponseDto> searchBookByName(String name);

    List<BookResponseDto> searchBooksByAuthor(String author);

    BookResponseDto getBookByExactName(String name);

    boolean existsBookByName(String name);

    List<BookResponseDto> searchBooksByNameAndAuthor(String name, String author);

    BookResponseDto updateBook(Long id, BookRequestDto bookRequestDto);



}
