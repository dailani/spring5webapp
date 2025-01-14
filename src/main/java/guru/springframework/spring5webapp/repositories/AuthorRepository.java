package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domainmodell.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
