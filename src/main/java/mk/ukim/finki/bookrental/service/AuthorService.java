package mk.ukim.finki.bookrental.service;

import mk.ukim.finki.bookrental.model.Author;
import mk.ukim.finki.bookrental.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(Author author);

//    Optional<Author> save(String name, String surname, Long countryId);

//    Optional<Author> edit(Long authorId, String name, String surname, Long countryId);

    void deleteById(Long id);
}
