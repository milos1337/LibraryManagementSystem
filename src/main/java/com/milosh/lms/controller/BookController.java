package com.milosh.lms.controller;

import com.milosh.lms.dto.BookResponseDTO;
import com.milosh.lms.dto.CreateBookDTO;
import com.milosh.lms.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> searchBooks(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String title
    ) {
        return ResponseEntity.ok(bookService.searchBooks(author, title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> addBook(@RequestBody @Valid CreateBookDTO bookDTO) {

        BookResponseDTO saved = bookService.addBook(bookDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @RequestBody @Valid BookResponseDTO bookResponseDTO) {
        return ResponseEntity.ok(bookService.updateBook(id, bookResponseDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);

        return ResponseEntity.noContent().build();
    }
}
