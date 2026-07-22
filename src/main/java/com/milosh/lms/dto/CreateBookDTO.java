package com.milosh.lms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateBookDTO {
    @NotBlank(message = "Title can't be empty")
    private String title;
    @NotBlank(message = "Author can't be empty")
    private String author;
    @NotBlank(message = "ISBN can't be empty")
    private String isbn;
    @NotNull(message = "Book publication year is required")
    private Integer publicationYear;
    @NotNull(message = "Number of total copies is required")
    private Integer totalCopies;
}
