package com.Tavin.libraryApi.repository;

import com.Tavin.libraryApi.model.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
