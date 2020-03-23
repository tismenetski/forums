package com.tismenetski.forums.controllers;

import com.tismenetski.forums.domain.Forum;
import com.tismenetski.forums.domain.Thread;
import com.tismenetski.forums.domain.User;
import com.tismenetski.forums.services.CommentService;
import com.tismenetski.forums.services.ForumService;
import com.tismenetski.forums.services.ThreadService;
import com.tismenetski.forums.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class CommentController {

    @Autowired
    private UserService userService;

    @Autowired
    private ForumService forumService;

    @Autowired
    private ThreadService threadService;

    @Autowired
    private CommentService commentService;







}
