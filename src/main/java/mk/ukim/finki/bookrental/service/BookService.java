package mk.ukim.finki.bookrental.service;

import mk.ukim.finki.bookrental.model.Author;
import mk.ukim.finki.bookrental.model.Book;
import mk.ukim.finki.bookrental.model.Country;
import mk.ukim.finki.bookrental.model.dto.BookDto;
import mk.ukim.finki.bookrental.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(Book book);

    Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long bookId, String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long bookId,BookDto bookDto);

    void deleteById(Long id);

}
