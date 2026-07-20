package com.milosh.lms.mapper;

import com.milosh.lms.dto.BookResponseDTO;
import com.milosh.lms.dto.CreateBookDTO;
import com.milosh.lms.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookResponseDTO toDTO(Book book) {

        BookResponseDTO dto = new BookResponseDTO();

        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setPublicationYear(book.getPublicationYear());
        dto.setTotalCopies(book.getTotalCopies());
        dto.setAvailableCopies(book.getAvailableCopies());

        return dto;
    }

    public Book toEntity(CreateBookDTO dto) {

        Book book = new Book();

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setPublicationYear(dto.getPublicationYear());
        book.setTotalCopies(dto.getTotalCopies());

        return book;
    }
}
