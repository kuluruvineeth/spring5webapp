package kuluru.springFramework.spring5webapp.bootstrap;

import kuluru.springFramework.spring5webapp.domain.Author;
import kuluru.springFramework.spring5webapp.domain.Book;
import kuluru.springFramework.spring5webapp.domain.Publisher;
import kuluru.springFramework.spring5webapp.repositories.AuthorRepository;
import kuluru.springFramework.spring5webapp.repositories.BookRepository;
import kuluru.springFramework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Books Publishing");
        publisher.setCity("Tampa");
        publisher.setState("Florida");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);
        Author rod = new Author("Rod","Johnson");
        Book book1 = new Book("Java Development","123456");
        rod.getBooks().add(book1);
        book1.getAuthors().add(rod);
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);
        authorRepository.save(rod);
        bookRepository.save(book1);
        publisherRepository.save(publisher);
        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: "+ bookRepository.count());
        System.out.println("Number of authors: "+ authorRepository.count());
        System.out.println("Publisher Number of books: "+ publisher.getBooks().size());
    }
}
