package com.ecates.bookapi.controller;

import com.ecates.bookapi.dto.request.PublisherRequestDto;
import com.ecates.bookapi.dto.response.PublisherResponseDto;
import com.ecates.bookapi.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherService;


    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public ResponseEntity<PublisherResponseDto> addPublishers(@RequestBody PublisherRequestDto publisherRequestDto){

        return ResponseEntity.ok(publisherService.addPublisher(publisherRequestDto));

    }

    @GetMapping
    public ResponseEntity<List<PublisherResponseDto>> getAllPublishers(){
        return ResponseEntity.ok(publisherService.getPublisherResponseList());
    }

}
