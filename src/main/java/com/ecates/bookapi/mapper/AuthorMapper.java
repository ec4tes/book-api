package com.ecates.bookapi.mapper;

import com.ecates.bookapi.dto.request.AuthorRequestDto;

import com.ecates.bookapi.dto.response.AuthorResponseDto;
import com.ecates.bookapi.entity.Author;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorResponseDto toResponseDto(Author author);

    List<AuthorResponseDto> toResponseDtoList(List<Author> authors);

    Author toEntity(AuthorRequestDto authorRequestDto);

}
