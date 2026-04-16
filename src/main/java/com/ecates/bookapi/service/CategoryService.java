package com.ecates.bookapi.service;

import com.ecates.bookapi.dto.request.CategotyRequestDto;
import com.ecates.bookapi.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto addCategory(CategotyRequestDto categotyRequestDto);

    List<CategoryResponseDto> getAllCategory();

}
