package com.tismenetski.forums.controllers;

import com.tismenetski.forums.domain.Forum;
import com.tismenetski.forums.domain.Thread;
import com.tismenetski.forums.services.ForumService;
import com.tismenetski.forums.services.ThreadService;
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


    //Currently Not passing the Forum Object , should pass the id and get the forum using the forum service , then , pass it to the thread service
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
       model.addAttribute("thread",thread);

       return "forumThread";
    }
}
