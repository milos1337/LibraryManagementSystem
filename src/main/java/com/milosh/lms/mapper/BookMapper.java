package com.milosh.lms.mapper;

import com.milosh.lms.dto.BookDTO;
import com.milosh.lms.entity.Book;

public class BookMapper {

    public static BookDTO toDTO(Book book) {

        BookDTO dto = new BookDTO();

        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setPublicationYear(book.getPublicationYear());
        dto.setTotalCopies(book.getTotalCopies());
        dto.setAvailableCopies(book.getAvailableCopies());

        return dto;
    }

    public static Book toEntity(BookDTO dto) {

        Book book = new Book();

        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setPublicationYear(dto.getPublicationYear());
        book.setTotalCopies(dto.getTotalCopies());
        book.setAvailableCopies(dto.getAvailableCopies());

        return book;
    }
}
