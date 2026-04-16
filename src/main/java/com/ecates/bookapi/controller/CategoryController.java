package com.ecates.bookapi.controller;

import com.ecates.bookapi.dto.request.CategotyRequestDto;
import com.ecates.bookapi.dto.response.CategoryResponseDto;
import com.ecates.bookapi.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody CategotyRequestDto categotyRequestDto){

        return  ResponseEntity.ok(categoryService.addCategory(categotyRequestDto));

    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategory(){

        return ResponseEntity.ok(categoryService.getAllCategory());

    }

}
