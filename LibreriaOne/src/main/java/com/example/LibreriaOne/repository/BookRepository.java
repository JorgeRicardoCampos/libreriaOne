package com.example.LibreriaOne.repository;

import com.example.LibreriaOne.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByLanguage(String language);
    boolean existsByTitle(String title); // Método para verificar si existe un libro con un título específico
}

