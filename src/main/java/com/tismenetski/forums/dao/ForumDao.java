package com.tismenetski.forums.dao;

import com.tismenetski.forums.domain.Category;
import com.tismenetski.forums.domain.Forum;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ForumDao extends CrudRepository<Forum,Long> {

    Set<Forum> findAllByOrderByIdAsc();

}
