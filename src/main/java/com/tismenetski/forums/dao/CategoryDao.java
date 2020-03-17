package com.tismenetski.forums.dao;

import com.tismenetski.forums.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category,Long> {

}
