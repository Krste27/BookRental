package mk.ukim.finki.bookrental.service.Impl;

import mk.ukim.finki.bookrental.model.Country;
import mk.ukim.finki.bookrental.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.bookrental.repository.CountryRepository;
import mk.ukim.finki.bookrental.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(Country country) {
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name,continent);
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public Optional<Country> edit(Long countryId, String name, String continent) {
        Country country = this.countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException(countryId));

        country.setName(name);
        country.setContinent(continent);

        return this.save(country);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
