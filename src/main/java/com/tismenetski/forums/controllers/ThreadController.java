package com.tismenetski.forums.controllers;

import com.tismenetski.forums.domain.Comment;
import com.tismenetski.forums.domain.Forum;
import com.tismenetski.forums.domain.Thread;
import com.tismenetski.forums.domain.User;
import com.tismenetski.forums.services.CommentService;
import com.tismenetski.forums.services.ForumService;
import com.tismenetski.forums.services.ThreadService;
import com.tismenetski.forums.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @Autowired
    private ForumService forumService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;



    @RequestMapping(value = "/forumsNewTopic", method = RequestMethod.POST)
    public String newTopicPOST(@ModelAttribute("thread") String thread, @ModelAttribute("comment") String comment, Principal principal,@ModelAttribute("id") String id)
    {
        Forum forum = forumService.findById(new Long(id));
        threadService.createThread(forum,principal,comment,thread);

        return "redirect:/" + forum.getId() +  "/forumsForum";
    }


    @RequestMapping(value = "/{id1}/forumsForum/forumsThread/{id}", method = RequestMethod.GET)
    public String postGET(@PathVariable String id, Model model,@PathVariable String id1)
    {
       System.out.println("TESTING");
       Thread thread = threadService.findById(new Long(id));
       Forum forum=forumService.findById(new Long(id1));
       model.addAttribute("thread",thread);
       model.addAttribute("forum",forum);

       return "forumThread";
    }
    /*
    @RequestMapping(value = "/{forumId}/forumsForum/forumsThread/{threadId}", method = RequestMethod.GET)
    public String postGET2(Model model, Principal principal, @PathVariable("forumId") String forumId, @PathVariable("threadId") String threadId)
    {
        Thread thread = threadService.findById(new Long(threadId));
        Forum forum=forumService.findById(new Long(forumId));
        model.addAttribute("thread",thread);
        model.addAttribute("forum",forum);
        System.out.println("TESTING22");
        return "forumThread";
    }
*/
    @RequestMapping(value = "/forumThread", method = RequestMethod.POST)
    public String commentPOST(@ModelAttribute("comment") String comment, Principal principal, @ModelAttribute("forumId") String forumId, @ModelAttribute("threadId") String threadId)
    {
        System.out.println("Reached here!!!");
        User user = userService.findByUsername(principal.getName());
        Forum forum = forumService.findById(new Long(forumId));
        Thread thread = threadService.findById(new Long(threadId));
        commentService.createComment(comment,user.getUsername().toString(),forumId,threadId);
        return "redirect:/" + forum.getId() +  "/forumsForum/forumsThread/"+ thread.getId();
    }



}
