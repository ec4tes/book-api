package com.ecates.bookapi.dto.response;

import lombok.*;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Builder
public class CategoryResponseDto {
    private Long id;
    private String name;
    private String description;
}
