package com.tismenetski.forums.dao;

import com.tismenetski.forums.domain.Thread;
import org.springframework.data.repository.CrudRepository;

public interface ThreadDao extends CrudRepository<Thread,Long> {

}
