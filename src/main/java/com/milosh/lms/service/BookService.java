package com.milosh.lms.service;

import com.milosh.lms.dto.BookDTO;
import com.milosh.lms.entity.Book;
import com.milosh.lms.exception.NoSuchBookException;
import com.milosh.lms.mapper.BookMapper;
import com.milosh.lms.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private Book getBookEntity(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchBookException("No such book found"));
    }

    public List<BookDTO> searchBooks(String author, String title) {

        if (author != null && title != null) {
            return bookRepository.findByAuthorAndTitle(author, title)
                    .stream()
                    .map(BookMapper::toDTO)
                    .toList();
        }

        if (author != null) {
            return bookRepository.findByAuthor(author)
                    .stream()
                    .map(BookMapper::toDTO)
                    .toList();
        }

        if (title != null) {
            return bookRepository.findByTitle(title)
                    .stream()
                    .map(BookMapper::toDTO)
                    .toList();
        }

        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDTO)
                .toList();
    }

    public BookDTO getBookById(Long id) {
        return BookMapper.toDTO(getBookEntity(id));
    }

    public BookDTO addBook(BookDTO bookDTO) {
        Book saved = bookRepository.save(BookMapper.toEntity(bookDTO));
        return BookMapper.toDTO(saved);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = getBookEntity(id);

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setTotalCopies(bookDTO.getTotalCopies());
        book.setAvailableCopies(bookDTO.getAvailableCopies());

        return BookMapper.toDTO(bookRepository.save(book));
    }

    public void deleteBook(Long id) {
        Book book = getBookEntity(id);

        bookRepository.deleteById(id);
    }
}
