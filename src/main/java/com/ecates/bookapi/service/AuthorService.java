package com.ecates.bookapi.service;

import com.ecates.bookapi.dto.request.AuthorRequestDto;
import com.ecates.bookapi.dto.response.AuthorResponseDto;

import java.util.List;

public interface AuthorService {

    AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);

    List<AuthorResponseDto> getAllAuthor();

}
