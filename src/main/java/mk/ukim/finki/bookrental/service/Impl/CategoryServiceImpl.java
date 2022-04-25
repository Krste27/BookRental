package mk.ukim.finki.bookrental.service.Impl;

import mk.ukim.finki.bookrental.model.enumerations.Category;
import mk.ukim.finki.bookrental.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() {
        return List.of(Category.values());
    }
}
