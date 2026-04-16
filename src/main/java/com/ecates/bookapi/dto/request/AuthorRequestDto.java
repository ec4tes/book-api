package com.ecates.bookapi.dto.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorRequestDto {

    private String name;

    private String surname;

    private String country;
}
