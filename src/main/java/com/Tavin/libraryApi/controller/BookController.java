package com.Tavin.libraryApi.controller;

import com.Tavin.libraryApi.dto.BookRecordDto;
import com.Tavin.libraryApi.model.BookModel;
import com.Tavin.libraryApi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookstore/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookModel> saveBook(@RequestBody BookRecordDto BookRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(BookRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id) {
        bookService.DeleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Book.");
    }
}
