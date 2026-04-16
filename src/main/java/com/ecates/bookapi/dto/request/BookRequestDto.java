package com.ecates.bookapi.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Builder
public class BookRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String isbn;

    @NotNull
    @Min(1)
    private Integer pageCount;


    @NotNull
    private Long authorId;

    @NotNull
    private Long categoryId;

    @NotNull
    private Long publisherId;



}
