package com.tismenetski.forums.services.UserServiceImpl;

import com.tismenetski.forums.dao.CategoryDao;
import com.tismenetski.forums.dao.ForumDao;
import com.tismenetski.forums.domain.Category;
import com.tismenetski.forums.domain.Forum;
import com.tismenetski.forums.services.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ForumServiceImpl  implements ForumService {

    @Autowired
    private ForumDao forumDao;

    public Set<Forum> getForums()
    {
        Set<Forum> forumSet = new HashSet<>();
        forumDao.findAll().iterator().forEachRemaining(forumSet::add);
        return forumSet;
    }

}
