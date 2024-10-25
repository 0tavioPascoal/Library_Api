package com.Tavin.libraryApi.repository;

import com.Tavin.libraryApi.model.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {
}
