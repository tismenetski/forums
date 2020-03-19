package com.tismenetski.forums.services;


import com.tismenetski.forums.domain.Forum;
import com.tismenetski.forums.domain.Thread;

import java.security.Principal;

public interface ThreadService {
    Thread createThread(Forum forum , Principal principal,String comment, String threadText);
}
