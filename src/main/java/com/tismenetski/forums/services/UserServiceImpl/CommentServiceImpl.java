package com.tismenetski.forums.services.UserServiceImpl;

import com.tismenetski.forums.dao.CommentDao;
import com.tismenetski.forums.dao.UserDao;
import com.tismenetski.forums.domain.Comment;
import com.tismenetski.forums.domain.Thread;
import com.tismenetski.forums.domain.User;
import com.tismenetski.forums.services.CommentService;
import com.tismenetski.forums.services.ThreadService;
import com.tismenetski.forums.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;


    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ThreadService threadService;






    public Comment createComment(String commentText, String userId, String forumId ,String threadId)
    {
        //Setting the comment
        Comment comment = new Comment();
        comment.setCommentText(commentText);
        Date date = Calendar.getInstance().getTime(); //Currently the date in the thread is the date of the thread
        comment.setCommentDate(date);

        //Setting the user
        User user = userService.findByUsername(userId);
        comment.setUser(user);

        //Setting the thread

        Thread thread = threadService.findById(new Long(threadId));
        comment.setThread(thread);

        commentDao.save(comment);

        return comment;


    }

}
