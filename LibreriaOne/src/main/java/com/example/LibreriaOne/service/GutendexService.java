package com.example.LibreriaOne.service;

import com.example.LibreriaOne.model.Author;
import com.example.LibreriaOne.model.Book;
import com.example.LibreriaOne.repository.AuthorRepository;
import com.example.LibreriaOne.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class GutendexService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public void fetchAndSaveBooks() {
        String url = "https://gutendex.com/books";
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);

        if (response != null && response.getResults() != null) {
            Arrays.stream(response.getResults()).forEach(result -> {
                if (result.getAuthors() != null && result.getAuthors().length > 0) {
                    GutendexAuthor firstAuthor = result.getAuthors()[0]; // Obtener el primer autor del resultado

                    Author author = new Author();
                    author.setName(firstAuthor.getName());
                    author.setBirthYear(firstAuthor.getBirthYear());
                    author.setDeathYear(firstAuthor.getDeathYear());
                    author = authorRepository.save(author);

                    // Resto del código para guardar el libro
                    if (!bookRepository.existsByTitle(result.getTitle())) {
                        Book book = new Book();
                        book.setTitle(result.getTitle());
                        book.setAuthor(author);
                        if (result.getLanguages() != null && result.getLanguages().length > 0) {
                            book.setLanguage(result.getLanguages()[0]);
                        }
                        book.setDownloadCount(result.getDownloadCount());
                        book.setReleaseYear(result.getReleaseYear());
                        bookRepository.save(book);
                    } else {
                        // Manejar el caso cuando el libro ya existe en la base de datos
                        System.out.println("El libro ya existe en la base de datos.");
                    }
                } else {
                    // Manejar el caso cuando no hay autores en el resultado
                    System.out.println("El libro no tiene autores.");
                }
            });
        }
    }
}
