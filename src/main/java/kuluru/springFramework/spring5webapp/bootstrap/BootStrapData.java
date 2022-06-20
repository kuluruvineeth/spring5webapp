package kuluru.springFramework.spring5webapp.bootstrap;

import kuluru.springFramework.spring5webapp.domain.Author;
import kuluru.springFramework.spring5webapp.domain.Book;
import kuluru.springFramework.spring5webapp.repositories.AuthorRepository;
import kuluru.springFramework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book book1 = new Book("Java Development","123456");
        rod.getBooks().add(book1);
        book1.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book1);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: "+ bookRepository.count());
        System.out.println("Number of authors: "+ authorRepository.count());
    }
}
