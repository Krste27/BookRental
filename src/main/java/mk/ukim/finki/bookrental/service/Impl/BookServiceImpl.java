package mk.ukim.finki.bookrental.service.Impl;

import mk.ukim.finki.bookrental.model.Author;
import mk.ukim.finki.bookrental.model.Book;
import mk.ukim.finki.bookrental.model.dto.BookDto;
import mk.ukim.finki.bookrental.model.enumerations.Category;
import mk.ukim.finki.bookrental.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.bookrental.model.exceptions.BookNotAvailable;
import mk.ukim.finki.bookrental.model.exceptions.BookNotFoundException;
import mk.ukim.finki.bookrental.repository.AuthorRepository;
import mk.ukim.finki.bookrental.repository.BookRepository;
import mk.ukim.finki.bookrental.repository.CountryRepository;
import mk.ukim.finki.bookrental.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(Book book) {
        return Optional.of(bookRepository.save(book));
    }

//    @Override
//    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {
//        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
//
//        Book book = new Book(name, category, author, availableCopies);
//        return Optional.of(this.bookRepository.save(book));
//    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }


//    @Override
//    public Optional<Book> edit(Long bookId, String name, Category category, Long authorId, Integer availableCopies) {
//        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
//        Book book = this.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
//
//        book.setName(name);
//        book.setCategory(category);
//        book.setAuthor(author);
//        book.setAvailableCopies(availableCopies);
//
//        return this.save(book);
//    }

    @Override
    public Optional<Book> edit(Long bookId, BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        Book book = this.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return this.save(book);
    }

    @Override
    public Optional<Book> takeBook(Long id) {
        Book book = this.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Integer current_avb_copies = book.getAvailableCopies();
        if (current_avb_copies == 0){
            throw new BookNotAvailable(id);
        }else {
            book.setAvailableCopies(current_avb_copies - 1);
        }
        return this.save(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
