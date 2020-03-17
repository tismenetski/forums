package com.tismenetski.forums.services.UserServiceImpl;

import com.tismenetski.forums.dao.CategoryDao;
import com.tismenetski.forums.domain.Category;
import com.tismenetski.forums.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;






    public Set<Category> getCategories()
    {
        Set<Category> categorySet = new HashSet<>();
        categoryDao.findAll().iterator().forEachRemaining(categorySet::add);
        return categorySet;
    }


}
