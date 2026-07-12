package com.milosh.lms.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private String title;
    private String isbn;
    private Integer publicationYear;
    private Integer totalCopies;
    private Integer availableCopies;
}
