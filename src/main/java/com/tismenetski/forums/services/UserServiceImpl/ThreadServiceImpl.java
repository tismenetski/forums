package com.tismenetski.forums.services.UserServiceImpl;

import com.tismenetski.forums.dao.CommentDao;
import com.tismenetski.forums.dao.ForumDao;
import com.tismenetski.forums.dao.ThreadDao;
import com.tismenetski.forums.dao.UserDao;
import com.tismenetski.forums.domain.Comment;
import com.tismenetski.forums.domain.Thread;
import com.tismenetski.forums.domain.Forum;
import com.tismenetski.forums.domain.User;
import com.tismenetski.forums.exceptions.NotFoundException;
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
import java.util.Optional;


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
    public Thread createThread(Forum forum , Principal principal,String commentText, String threadText)
    {
        //Objects
        Thread thread = new Thread();
        Comment comment= new Comment(); //added
        User user = userService.findByUsername(principal.getName());
        Date date= Calendar.getInstance().getTime();

        //Adding Values to objects
        comment.setCommentText(commentText);
        comment.setThread(thread);
        comment.setUser(user);
        comment.setCommentDate(date);
        thread.setThreadText(threadText);
        thread.setUser(user);
        thread.setForum(forum);
        thread.setThreadDate(date);

        //Saving Dao
        forumDao.save(forum);
        threadDao.save(thread);
        commentDao.save(comment);

        return thread;
    }

    @Override
    public Thread findById(Long l)
    {
        Optional<Thread> threadOptional= threadDao.findById(l);
        if (!threadOptional.isPresent())
        {
            throw new NotFoundException("Recipe Not Found. For ID value: " +l.toString());
        }

        return threadOptional.get();
    }
}
