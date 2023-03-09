package com.dum.OnlineBookstore.service;

import com.dum.OnlineBookstore.model.BookEntity;
import com.dum.OnlineBookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    //GET endpoint
    public List<BookEntity> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<BookEntity> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<BookEntity> searchBooks(String title, String author, BigDecimal price) {
        List<BookEntity> books = new ArrayList<>();
        if (title != null) {
            books.addAll(bookRepository.findByTitle(title));
        }
        if (author != null) {
            books.addAll(bookRepository.findByAuthor(author));
        }
        if (price != null) {
            books.addAll(bookRepository.findByPrice(price));
        }
        return books;
    }

    //POST endpoint
    public BookEntity createBook(BookEntity book) {
        return bookRepository.save(book);
    }

    //PUT endpoint
    public BookEntity editBook(BookEntity book) {
        return bookRepository.save(book);
    }

    //DEL
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


}
