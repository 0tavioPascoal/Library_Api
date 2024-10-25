package com.Tavin.libraryApi.service;

import com.Tavin.libraryApi.dto.BookRecordDto;
import com.Tavin.libraryApi.model.BookModel;
import com.Tavin.libraryApi.model.ReviewModel;
import com.Tavin.libraryApi.repository.AuthorRepository;
import com.Tavin.libraryApi.repository.BookRepository;
import com.Tavin.libraryApi.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public BookModel saveBook(BookRecordDto bookRecordDto) {
        BookModel book = new BookModel();
        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(bookRecordDto.auhtorsIds()).stream().collect(Collectors.toSet()));

        ReviewModel reviewmodel = new ReviewModel();
        reviewmodel.setComment(bookRecordDto.reviewComment());
        reviewmodel.setBook(book);
        book.setReview(reviewmodel);

        return bookRepository.save(book);
    }

    @Transactional
    public void DeleteBook(UUID bookId) {
        bookRepository.deleteById(bookId);
    }
}
