package com.ecates.bookapi.dto.response;

import lombok.*;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Builder
public class BookResponseDto {
    private Long id;
    private String name;
    private String isbn;
    private Integer pageCount;
    private AuthorResponseDto author;
    private CategoryResponseDto category;
    private PublisherResponseDto publisher;


}
