package com.tismenetski.forums.controllers;


import com.tismenetski.forums.domain.Forum;
import com.tismenetski.forums.domain.User;
import com.tismenetski.forums.services.CategoryService;
import com.tismenetski.forums.services.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @Autowired
    ForumService forumService;


    @GetMapping("/{id}/forumsForum")
    public String showById(@PathVariable String id, Model model)
    {
        model.addAttribute("forum",forumService.findById(new Long(id)));

        return "forumsForum";
    }



}
