package com.ecates.bookapi.controller;

import com.ecates.bookapi.dto.BookRequestDto;
import com.ecates.bookapi.dto.BookResponseDto;
import com.ecates.bookapi.service.BookService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> getBookById(@PathVariable Long id){
        BookResponseDto book = bookService.getBookById(id);

        if (book==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(book);

    }

    @PostMapping
    public ResponseEntity<BookResponseDto> addBook(@RequestBody BookRequestDto bookRequestDto){
        return ResponseEntity.ok(bookService.addBook(bookRequestDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        String result = bookService.deleteBook(id);

        if (result.equals("Kitap bulunamadı")){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);


    }



    @GetMapping("/search")
    public ResponseEntity<List<BookResponseDto>> searchBooks(@RequestParam String name) {
        return ResponseEntity.ok(bookService.searchBookByName(name));
    }


    @GetMapping("/author/books")
    public ResponseEntity<List<BookResponseDto>> searchAuthorBooks(@RequestParam String author){
        return ResponseEntity.ok(bookService.searchBooksByAuthor(author));
    }

    @GetMapping("/name/book")
    public ResponseEntity<BookResponseDto> searchBookName(@RequestParam String name){
        return ResponseEntity.ok(bookService.getBookByExactName(name));
    }

    @GetMapping("book/ispresent")
    public ResponseEntity<Boolean> isPresent(@RequestParam String name){
        boolean b = bookService.existsBookByName(name);
        return ResponseEntity.ok(b);
    }

    @GetMapping("/nameAndAutthor")
    public ResponseEntity<List<BookResponseDto>> serachNameAuthor(@RequestParam String name, String author){
        List<BookResponseDto> responseDtoList = bookService.searchBooksByNameAndAuthor(name, author);
        return ResponseEntity.ok(responseDtoList);
    }




}
