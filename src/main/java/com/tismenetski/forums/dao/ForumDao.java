package com.tismenetski.forums.dao;

import com.tismenetski.forums.domain.Forum;
import org.springframework.data.repository.CrudRepository;

public interface ForumDao extends CrudRepository<Forum,Long> {

}
