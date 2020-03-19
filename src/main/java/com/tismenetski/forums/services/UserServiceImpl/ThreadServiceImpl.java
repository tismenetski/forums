package com.tismenetski.forums.services.UserServiceImpl;

import com.tismenetski.forums.dao.CommentDao;
import com.tismenetski.forums.dao.ForumDao;
import com.tismenetski.forums.dao.ThreadDao;
import com.tismenetski.forums.dao.UserDao;
import com.tismenetski.forums.domain.Comment;
import com.tismenetski.forums.domain.Thread;
import com.tismenetski.forums.domain.Forum;
import com.tismenetski.forums.domain.User;
import com.tismenetski.forums.services.ForumService;
import com.tismenetski.forums.services.ThreadService;
import com.tismenetski.forums.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private UserService userService;

    @Autowired
    private ForumService forumService;

    @Autowired
    private ThreadDao threadDao;

    @Autowired
    private ForumDao forumDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;


    @Override
    @Transactional
    public Thread createThread(Forum forum , Principal principal,String comment, String threadText)
    {
        /*So the controller can reach the service since the sout below working*/
        System.out.println("testing");


        Thread thread = new Thread();
        Comment comment1= new Comment(); //added
        comment1.setCommentText(comment); //added
        thread.setThreadText("Testing new Thread");
        User user = userService.findByUsername(principal.getName());
        thread.setUser(user);
        thread.setForum(forum);
        //threadDao.save(thread);
        forumDao.save(forum);
        threadDao.save(thread); //added
        commentDao.save(comment1); //added


        return thread;



    }

}
