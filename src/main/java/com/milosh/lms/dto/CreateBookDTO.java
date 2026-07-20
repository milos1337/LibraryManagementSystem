package com.milosh.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateBookDTO {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private int totalCopies;
}
