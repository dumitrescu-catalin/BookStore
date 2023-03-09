package com.dum.OnlineBookstore.controller;
import com.dum.OnlineBookstore.exception.ResourceNotFoundException;
import com.dum.OnlineBookstore.model.BookEntity;
import com.dum.OnlineBookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private final BookService bookService;




    //POST
    @PostMapping("/create")
    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity book) {
        BookEntity book1 = bookService.createBook(book);
        return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/edit")
    public ResponseEntity<BookEntity> editBook(@RequestBody BookEntity book){
        return new ResponseEntity<>(bookService.editBook(book),HttpStatus.ACCEPTED);
    }

    //DEL
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long id){
        bookService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book with id: " + id + " has not found!"));
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book with id: " + id + " deleted successfully", HttpStatus.OK);
    }

    //GET
    @GetMapping("/search")
    public ResponseEntity<List<BookEntity>> searchBook(
            @PathVariable @RequestParam(value = "title", required = false) String title,
            @PathVariable @RequestParam(value = "author", required = false) String author,
            @PathVariable @RequestParam(value = "price", required = false) BigDecimal price) {
        return ResponseEntity.ok(bookService.searchBooks(title, author, price));
    }

    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookEntity>> getBookById(@PathVariable Long id) throws Exception {
        Optional<BookEntity> book1 = bookService.findById(id);
        if (book1.isEmpty()) {
            throw new ResourceNotFoundException("There is no book with id " + id);
        } else return ResponseEntity.ok(book1);
    }




}

