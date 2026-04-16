package com.ecates.bookapi.mapper;

import com.ecates.bookapi.dto.request.CategotyRequestDto;
import com.ecates.bookapi.dto.response.CategoryResponseDto;
import com.ecates.bookapi.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponseDto toResponseDto(Category category);

    List<CategoryResponseDto> toResponseDtoLıst(List<Category> categories);

    Category toEntity(CategotyRequestDto categotyRequestDto);


}
