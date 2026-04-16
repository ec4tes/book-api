package com.ecates.bookapi.dto.response;

import lombok.*;


@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Builder
public class AuthorResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String country;


}
