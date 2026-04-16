package com.ecates.bookapi.service.impl;

import com.ecates.bookapi.dto.request.PublisherRequestDto;
import com.ecates.bookapi.dto.response.PublisherResponseDto;
import com.ecates.bookapi.entity.Publisher;
import com.ecates.bookapi.mapper.PublisherMapper;
import com.ecates.bookapi.repository.PublisherRepository;
import com.ecates.bookapi.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public PublisherServiceImpl(PublisherRepository publisherRepository, PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    @Override
    public PublisherResponseDto addPublisher(PublisherRequestDto publisherRequestDto) {
        Publisher publisher = publisherMapper.toEntity(publisherRequestDto);
        Publisher savedPublisher  = publisherRepository.save(publisher);
        return publisherMapper.toResponseDto(savedPublisher);
    }

    @Override
    public List<PublisherResponseDto> getPublisherResponseList() {

        return publisherMapper.toResponseDtoList(publisherRepository.findAll());

    }
}
