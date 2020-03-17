package com.tismenetski.forums.services;

import com.tismenetski.forums.domain.Category;

import java.util.Set;

public interface CategoryService {

    Set<Category> getCategories();
}
