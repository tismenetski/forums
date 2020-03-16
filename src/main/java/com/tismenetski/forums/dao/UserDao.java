package com.tismenetski.forums.dao;

import com.tismenetski.forums.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
    User findByUsername(String username);//Spring will automatically know to bind findBy to what string is attached to it
    User findByEmail(String email);
}
