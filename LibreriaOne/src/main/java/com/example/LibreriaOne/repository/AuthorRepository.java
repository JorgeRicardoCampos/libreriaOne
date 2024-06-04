package com.example.LibreriaOne.repository;

import com.example.LibreriaOne.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

