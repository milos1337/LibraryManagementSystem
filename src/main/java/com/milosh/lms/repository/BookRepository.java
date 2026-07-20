package com.milosh.lms.repository;

import com.milosh.lms.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByTitle(String title);

    List<Book> findByAuthorAndTitle(String author, String title);

    boolean existsByIsbn(String isbn);
}
