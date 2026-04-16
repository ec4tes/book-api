package com.ecates.bookapi.controller;


import com.ecates.bookapi.dto.request.AuthorRequestDto;
import com.ecates.bookapi.dto.response.AuthorResponseDto;
import com.ecates.bookapi.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        return ResponseEntity.ok(authorService.addAuthor(authorRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthors(){
        return ResponseEntity.ok(authorService.getAllAuthor());
    }

}
