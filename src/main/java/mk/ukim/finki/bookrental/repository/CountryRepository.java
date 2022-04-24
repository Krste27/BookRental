package mk.ukim.finki.bookrental.repository;

import mk.ukim.finki.bookrental.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
