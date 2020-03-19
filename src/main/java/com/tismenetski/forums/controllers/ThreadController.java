package com.tismenetski.forums.controllers;

import com.tismenetski.forums.domain.Forum;
import com.tismenetski.forums.services.ForumService;
import com.tismenetski.forums.services.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        System.out.println("Raeched here newTopicPOST");
        threadService.createThread(forum,principal,comment,thread);

        return "redirect:/" + forum.getId() +  "/forumsForum";
    }
}
