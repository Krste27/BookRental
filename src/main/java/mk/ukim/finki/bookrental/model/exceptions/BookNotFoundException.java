package mk.ukim.finki.bookrental.model.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super(String.format("Book with id %d was not found", id));
    }
}
