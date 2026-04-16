package com.ecates.bookapi.mapper;

import com.ecates.bookapi.dto.request.BookRequestDto;
import com.ecates.bookapi.dto.response.BookResponseDto;
import com.ecates.bookapi.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookResponseDto toResponseDto(Book book);

    List<BookResponseDto> toResponseDtoList(List<Book> books);

    Book toEntity(BookRequestDto bookRequestDto);


}
