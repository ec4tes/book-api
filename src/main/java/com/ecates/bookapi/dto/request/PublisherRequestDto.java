package com.ecates.bookapi.dto.request;


import lombok.*;

@AllArgsConstructor@NoArgsConstructor@Getter@Setter
@Builder
public class PublisherRequestDto {

    private String name;
    private String country;


}
