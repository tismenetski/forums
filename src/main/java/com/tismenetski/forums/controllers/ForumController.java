package com.tismenetski.forums.controllers;

import com.tismenetski.forums.services.CategoryService;
import com.tismenetski.forums.services.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForumController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ForumService forumService;


    //@RequestMapping(value = )

    @GetMapping("{id}/forumsForum/forumsNewTopic")
    public String showById(@PathVariable String id, Model model)
    {
        model.addAttribute("forum",forumService.findById(new Long(id)));

        return  "forumsNewTopic";
    }
}
