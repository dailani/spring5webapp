package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domainmodell.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
