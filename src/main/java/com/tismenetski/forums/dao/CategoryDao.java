package com.tismenetski.forums.dao;

import com.tismenetski.forums.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface CategoryDao extends CrudRepository<Category,Long> {


    Set<Category> findAllByOrderByIdAsc();

}
