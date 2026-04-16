package com.ecates.bookapi.service.impl;

import com.ecates.bookapi.dto.request.CategotyRequestDto;
import com.ecates.bookapi.dto.response.CategoryResponseDto;
import com.ecates.bookapi.entity.Category;
import com.ecates.bookapi.mapper.CategoryMapper;
import com.ecates.bookapi.repository.CategoryRepository;
import com.ecates.bookapi.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorySericeImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategorySericeImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryResponseDto addCategory(CategotyRequestDto categotyRequestDto) {
        Category category = categoryMapper.toEntity(categotyRequestDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toResponseDto(category);
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        return categoryMapper.toResponseDtoLıst(categoryRepository.findAll());
    }
}
