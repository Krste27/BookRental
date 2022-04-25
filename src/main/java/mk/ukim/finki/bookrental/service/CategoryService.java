package mk.ukim.finki.bookrental.service;

import mk.ukim.finki.bookrental.model.enumerations.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}
