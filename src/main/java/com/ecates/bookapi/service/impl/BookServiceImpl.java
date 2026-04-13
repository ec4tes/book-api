package com.ecates.bookapi.service.impl;

import com.ecates.bookapi.dto.BookRequestDto;
import com.ecates.bookapi.dto.BookResponseDto;
import com.ecates.bookapi.entity.Book;
import com.ecates.bookapi.mapper.BookMapper;
import com.ecates.bookapi.repository.BookRepository;
import com.ecates.bookapi.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toResponseDtoList(books);

    }

    @Override
    public BookResponseDto getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()){
            return  bookMapper.toResponseDto(optionalBook.get());


        }
        return null;

    }

    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        Book book = bookMapper.toEntity(bookRequestDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toResponseDto(savedBook);
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
        return bookMapper.toResponseDtoList(books);

    }
    /// ///////////////////////////
    @Override
    public List<BookResponseDto> searchBooksByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthorContainingIgnoreCase(author);
        return bookMapper.toResponseDtoList(books);

    }

    @Override
    public BookResponseDto getBookByExactName(String name) {

        Optional<Book> book = bookRepository.findByNameIgnoreCase(name);
        if (book.isPresent()){
            return bookMapper.toResponseDto(book.get());
        }
        return null;

    }



    @Override
    public boolean existsBookByName(String name) {
        return bookRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public List<BookResponseDto> searchBooksByNameAndAuthor(String name, String author) {
        List<Book> books = bookRepository.findByNameContainingIgnoreCaseAndAuthorContainsIgnoreCase(name, author);
        return bookMapper.toResponseDtoList(books);
    }
}
