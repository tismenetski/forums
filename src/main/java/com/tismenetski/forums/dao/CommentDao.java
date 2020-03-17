package com.tismenetski.forums.dao;

import com.tismenetski.forums.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentDao extends CrudRepository<Comment,Long> {

}
