package com.ecates.bookapi.dto.request;


import lombok.*;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Builder
public class CategotyRequestDto {
    private String name;
    private String description;
}
