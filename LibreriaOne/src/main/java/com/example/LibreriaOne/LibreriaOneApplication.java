package com.example.LibreriaOne;

import com.example.LibreriaOne.model.Author;
import com.example.LibreriaOne.model.Book;
import com.example.LibreriaOne.AuthorService.AuthorService;
import com.example.LibreriaOne.BookService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LibreriaOneApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	public static void main(String[] args) {
		SpringApplication.run(LibreriaOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("************************");
			System.out.println("Elije una opción a través del número:");
			System.out.println("1- Buscar libro por el Título");
			System.out.println("2- Listar libros registrados");
			System.out.println("3- Listar autores registrados");
			System.out.println("4- Listar autores vivos en un determinado año");
			System.out.println("5- Listar libros por idioma");
			System.out.println("0- Salir");
			System.out.println("************************");

			int option = scanner.nextInt();
			scanner.nextLine();  // Consume newline

			switch (option) {
				case 1:
					System.out.print("Introduce el título del libro: ");
					String title = scanner.nextLine();
					List<Book> booksByTitle = bookService.getBooksByTitle(title);
					booksByTitle.forEach(book -> System.out.println(book.getTitle()));
					break;
				case 2:
					List<Book> books = bookService.getAllBooks();
					books.forEach(book -> System.out.println(book.getTitle()));
					break;
				case 3:
					List<Author> authors = authorService.getAllAuthors();
					authors.forEach(author -> System.out.println(author.getName()));
					break;
				case 4:
					System.out.print("Introduce el año: ");
					int year = scanner.nextInt();
					List<Author> livingAuthors = authorService.getLivingAuthorsInYear(year);
					livingAuthors.forEach(author -> System.out.println(author.getName()));
					break;
				case 5:
					System.out.print("Introduce el idioma: ");
					String language = scanner.nextLine();
					List<Book> booksByLanguage = bookService.getBooksByLanguage(language);
					booksByLanguage.forEach(book -> System.out.println(book.getTitle()));
					break;
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("Opción no válida.");
			}
		}
	}
}
