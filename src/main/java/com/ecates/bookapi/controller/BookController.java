package com.ecates.bookapi.controller;

import com.ecates.bookapi.dto.request.BookRequestDto;
import com.ecates.bookapi.dto.response.BookResponseDto;

import com.ecates.bookapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks(){

        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById( @PathVariable Long id){

        BookResponseDto book = bookService.getBookById(id);

        return ResponseEntity.ok(book);

    }

    @PostMapping
    public ResponseEntity<BookResponseDto> addBook(@Valid @RequestBody BookRequestDto bookRequestDto){

        return ResponseEntity.ok(bookService.addBook(bookRequestDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook( @PathVariable Long id){

        bookService.deleteBook(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookResponseDto>> searchBooks( @RequestParam String name) {

        return ResponseEntity.ok(bookService.searchBookByName(name));
    }

    @GetMapping("/search-by-author")
    public ResponseEntity<List<BookResponseDto>> searchAuthorBooks(@RequestParam String author){

        return ResponseEntity.ok(bookService.searchBooksByAuthor(author));
    }

    @GetMapping("/exact-name")
    public ResponseEntity<BookResponseDto> searchBookName( @RequestParam String name){

        return ResponseEntity.ok(bookService.getBookByExactName(name));
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> isPresent( @RequestParam String name){

        boolean b = bookService.existsBookByName(name);

        return ResponseEntity.ok(b);
    }

    @GetMapping("/search-by-name-and-author")
    public ResponseEntity<List<BookResponseDto>> searchNameAuthor( @RequestParam String name, @RequestParam String author){

        List<BookResponseDto> responseDtoList = bookService.searchBooksByNameAndAuthor(name, author);

        return ResponseEntity.ok(responseDtoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(@PathVariable Long id ,@Valid @RequestBody BookRequestDto bookRequestDto){

        BookResponseDto bookResponseDto = bookService.updateBook(id, bookRequestDto);

        return ResponseEntity.ok(bookResponseDto);

    }

}
