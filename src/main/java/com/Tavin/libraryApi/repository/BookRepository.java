package com.Tavin.libraryApi.repository;

import com.Tavin.libraryApi.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {
}
