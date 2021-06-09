package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domainmodell.Author;
import guru.springframework.spring5webapp.domainmodell.Book;
import guru.springframework.spring5webapp.domainmodell.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("Tirona");
        publisher.setState("ALB");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book domainbook = new Book("Domain Driven Design ", "123123");
        eric.getBooks().add(domainbook);
        domainbook.getAuthors().add(eric);

        domainbook.setPublisher(publisher);
        publisher.getBooks().add(domainbook);

        authorRepository.save(eric);
        bookRepository.save(domainbook);
        publisherRepository.save(publisher);

        Author rad = new Author("Rad", "Johnson");
        Book noEJB = new Book("J2EE", "432534");
        rad.getBooks().add(noEJB);
        noEJB.getAuthors().add(rad);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rad);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

    }
}
