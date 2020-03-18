package com.tismenetski.forums.services;

import com.tismenetski.forums.domain.Forum;

import java.util.Set;

public interface ForumService {

    Set<Forum> getForums();
    Forum findById(Long l);
}
