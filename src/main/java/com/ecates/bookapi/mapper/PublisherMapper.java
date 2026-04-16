package com.ecates.bookapi.mapper;

import com.ecates.bookapi.dto.request.PublisherRequestDto;
import com.ecates.bookapi.dto.response.PublisherResponseDto;
import com.ecates.bookapi.entity.Publisher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherResponseDto toResponseDto(Publisher publisher);

    List<PublisherResponseDto> toResponseDtoList(List<Publisher>publishers);

    Publisher toEntity(PublisherRequestDto publisherRequestDto);


}
