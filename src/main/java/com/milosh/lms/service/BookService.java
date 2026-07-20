package com.milosh.lms.service;

import com.milosh.lms.dto.BookDTO;
import com.milosh.lms.entity.Book;
import com.milosh.lms.exception.BookAlreadyExistsException;
import com.milosh.lms.exception.BookNotFoundException;
import com.milosh.lms.mapper.BookMapper;
import com.milosh.lms.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper mapper;

    private Book getBookEntity(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found."));
    }

    public List<BookDTO> searchBooks(String author, String title) {

        if (author != null && title != null) {
            return bookRepository.findByAuthorAndTitle(author, title)
                    .stream()
                    .map(mapper::toDTO)
                    .toList();
        }

        if (author != null) {
            return bookRepository.findByAuthor(author)
                    .stream()
                    .map(mapper::toDTO)
                    .toList();
        }

        if (title != null) {
            return bookRepository.findByTitle(title)
                    .stream()
                    .map(mapper::toDTO)
                    .toList();
        }

        return bookRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public BookDTO getBookById(Long id) {
        return mapper.toDTO(getBookEntity(id));
    }

    public BookDTO addBook(BookDTO bookDTO) {

        if (bookRepository.existsByIsbn(bookDTO.getIsbn())) {
            throw new BookAlreadyExistsException(
                    "Book with ISBN " + bookDTO.getIsbn() + " already exists."
            );
        }

        Book book = mapper.toEntity(bookDTO);

        Book saved = bookRepository.save(book);

        return mapper.toDTO(saved);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = getBookEntity(id);

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setTotalCopies(bookDTO.getTotalCopies());
        book.setAvailableCopies(bookDTO.getAvailableCopies());

        return mapper.toDTO(bookRepository.save(book));
    }

    public void deleteBook(Long id) {
        Book book = getBookEntity(id);

        bookRepository.deleteById(id);
    }
}
