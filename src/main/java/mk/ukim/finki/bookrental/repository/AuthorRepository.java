package mk.ukim.finki.bookrental.repository;

import mk.ukim.finki.bookrental.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
