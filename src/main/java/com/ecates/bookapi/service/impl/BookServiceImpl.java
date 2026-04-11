package com.ecates.bookapi.service.impl;

import com.ecates.bookapi.dto.BookRequestDto;
import com.ecates.bookapi.dto.BookResponseDto;
import com.ecates.bookapi.entity.Book;
import com.ecates.bookapi.repository.BookRepository;
import com.ecates.bookapi.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResponseDto> responseDtoList = new ArrayList<>();

        for (Book book: books){
            responseDtoList.add(BookResponseDto.builder()
                    .id(book.getId())
                    .name(book.getName())
                    .author(book.getAuthot())
                    .build()
            );
        }
        return responseDtoList;
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()){
            Book book = optionalBook.get();
            return  BookResponseDto.builder()
                    .id(book.getId())
                    .name(book.getName())
                    .author(book.getAuthot())
                    .build();


        }
        return null;

    }

    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        Book book = Book.builder()
                .name(bookRequestDto.getName())
                .authot(bookRequestDto.getAuthor())
                .build();
        Book savedBook = bookRepository.save(book);
        return BookResponseDto.builder()
                .id(savedBook.getId())
                .name(savedBook.getName())
                .author(savedBook.getAuthot())
                .build();

    }

    @Override
    public String deleteBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            bookRepository.deleteById(id);
            return "Kitap başarı ile silindi";
        }
        return "Kitap bulunamadı";
    }

    @Override
    public List<BookResponseDto> searchBookByName(String name) {
        List<Book> books = bookRepository.findByNameContainingIgnoreCase(name);
        List<BookResponseDto> responseDtoList = new ArrayList<>();

        for (Book book : books){
            responseDtoList.add(new BookResponseDto(
                    book.getId(),
                    book.getName(),
                    book.getAuthot()
            ));
        }
        return responseDtoList;

    }
}
