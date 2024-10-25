package com.Tavin.libraryApi.repository;

import com.Tavin.libraryApi.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}
