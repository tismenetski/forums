package com.tismenetski.forums.controllers;

import com.tismenetski.forums.dao.RoleDao;
import com.tismenetski.forums.domain.Category;
import com.tismenetski.forums.domain.User;
import com.tismenetski.forums.domain.security.UserRole;
import com.tismenetski.forums.services.CategoryService;
import com.tismenetski.forums.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RoleDao roleDao;


    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "signup";
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") User user, Model model) {

        if(userService.checkUserExists(user.getUsername(), user.getEmail()))  {

            if (userService.checkEmailExists(user.getEmail())) {
                model.addAttribute("emailExists", true);
            }

            if (userService.checkUsernameExists(user.getUsername())) {
                model.addAttribute("usernameExists", true);
            }

            return "signup";
        } else {
            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));

            userService.createUser(user, userRoles);

            return "redirect:/";
        }
    }

    @RequestMapping("/forumsHome")
    public String forumsHome(Principal principal,Model model)
    {
        User user = userService.findByUsername(principal.getName());
        Set<Category> categories = categoryService.getCategories();
        model.addAttribute("user",user);
        model.addAttribute("categories",categories);


        return "forumsHome";
    }


}
