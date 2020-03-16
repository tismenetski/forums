package com.tismenetski.forums.dao;

import com.tismenetski.forums.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role,Long> {

    Role findByName(String name);
}
