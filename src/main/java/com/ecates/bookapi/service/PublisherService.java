package com.ecates.bookapi.service;


import com.ecates.bookapi.dto.request.PublisherRequestDto;
import com.ecates.bookapi.dto.response.PublisherResponseDto;

import java.util.List;

public interface PublisherService {

    PublisherResponseDto addPublisher(PublisherRequestDto publisherRequestDto);

    List<PublisherResponseDto> getPublisherResponseList();

}
