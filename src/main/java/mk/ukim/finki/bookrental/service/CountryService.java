package mk.ukim.finki.bookrental.service;

import mk.ukim.finki.bookrental.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(Country country);

//    Optional<Country> save(String name, String continent);

//    Optional<Country> edit(Long countryId, String name, String continent);

    void deleteById(Long id);
}
