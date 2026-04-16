package com.ecates.bookapi.service.impl;

import com.ecates.bookapi.dto.request.AuthorRequestDto;
import com.ecates.bookapi.dto.response.AuthorResponseDto;
import com.ecates.bookapi.entity.Author;
import com.ecates.bookapi.mapper.AuthorMapper;
import com.ecates.bookapi.repository.AuthorRepository;
import com.ecates.bookapi.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
        Author author = authorMapper.toEntity(authorRequestDto);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toResponseDto(savedAuthor);

    }

    @Override
    public List<AuthorResponseDto> getAllAuthor() {

        return authorMapper.toResponseDtoList(authorRepository.findAll());

    }
}
