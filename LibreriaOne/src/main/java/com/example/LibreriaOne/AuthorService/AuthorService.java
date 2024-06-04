package com.example.LibreriaOne.AuthorService;

import com.example.LibreriaOne.model.Author;
import com.example.LibreriaOne.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getLivingAuthorsInYear(int year) {
        return authorRepository.findAll().stream()
                .filter(author -> author.getBirthYear() <= year && (author.getDeathYear() == null || author.getDeathYear() > year))
                .toList();
    }
}
