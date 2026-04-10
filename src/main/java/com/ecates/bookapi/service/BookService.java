package com.ecates.bookapi.service;

import com.ecates.bookapi.dto.BookRequestDto;
import com.ecates.bookapi.dto.BookResponseDto;

import java.util.List;

public interface BookService {
    List<BookResponseDto> getAllBooks();

    BookResponseDto getBookById(Long id);

    BookResponseDto addBook(BookRequestDto bookRequestDto);

    String deleteBook(Long id);

    List<BookResponseDto> searchBookByName(String name);


}
