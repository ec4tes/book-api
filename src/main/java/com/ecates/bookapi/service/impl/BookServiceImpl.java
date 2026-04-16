package com.ecates.bookapi.service.impl;

import com.ecates.bookapi.dto.request.BookRequestDto;
import com.ecates.bookapi.dto.response.BookResponseDto;
import com.ecates.bookapi.entity.Author;
import com.ecates.bookapi.entity.Book;
import com.ecates.bookapi.entity.Category;
import com.ecates.bookapi.entity.Publisher;
import com.ecates.bookapi.mapper.BookMapper;
import com.ecates.bookapi.repository.AuthorRepository;
import com.ecates.bookapi.repository.BookRepository;
import com.ecates.bookapi.repository.CategoryRepository;
import com.ecates.bookapi.repository.PublisherRepository;
import com.ecates.bookapi.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final PublisherRepository publisherRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           CategoryRepository categoryRepository,
                           PublisherRepository publisherRepository,
                           BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.publisherRepository = publisherRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        return bookMapper.toResponseDtoList(bookRepository.findAll());
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        return bookMapper.toResponseDto(book);
    }

    @Override
    public BookResponseDto addBook(BookRequestDto dto) {
        Book book = bookMapper.toEntity(dto);

        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author bulunamadı"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));

        Publisher publisher = publisherRepository.findById(dto.getPublisherId())
                .orElseThrow(() -> new RuntimeException("Yayınevi bulunamadı"));

        book.setAuthor(author);
        book.setCategory(category);
        book.setPublisher(publisher);

        Book savedBook = bookRepository.save(book);

        return bookMapper.toResponseDto(savedBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        bookRepository.deleteById(id);
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        book.setName(dto.getName());
        book.setIsbn(dto.getIsbn());
        book.setPageCount(dto.getPageCount());

        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author bulunamadı"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));

        Publisher publisher = publisherRepository.findById(dto.getPublisherId())
                .orElseThrow(() -> new RuntimeException("Yayınevi bulunamadı"));

        book.setAuthor(author);
        book.setCategory(category);
        book.setPublisher(publisher);

        Book savedBook = bookRepository.save(book);

        return bookMapper.toResponseDto(savedBook);
    }

    @Override
    public List<BookResponseDto> searchBookByName(String name) {
        return bookMapper.toResponseDtoList(
                bookRepository.findByNameContainingIgnoreCase(name)
        );
    }

    @Override
    public List<BookResponseDto> searchBooksByAuthor(String author) {
        return bookMapper.toResponseDtoList(
                bookRepository.findByAuthor_NameContainingIgnoreCase(author)
        );
    }

    @Override
    public BookResponseDto getBookByExactName(String name) {
        Book book = bookRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        return bookMapper.toResponseDto(book);
    }

    @Override
    public boolean existsBookByName(String name) {
        return bookRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public List<BookResponseDto> searchBooksByNameAndAuthor(String name, String author) {
        return bookMapper.toResponseDtoList(
                bookRepository.findByNameContainingIgnoreCaseAndAuthor_NameContainingIgnoreCase(name, author)
        );
    }
}