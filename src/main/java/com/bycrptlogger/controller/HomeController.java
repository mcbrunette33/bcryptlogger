package com.bycrptlogger.controller;


import com.bycrptlogger.model.Posts;
import com.bycrptlogger.model.SiteUser;
import com.bycrptlogger.repository.PostsRepository;
import com.bycrptlogger.repository.SiteUserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


    @Controller
    public class HomeController {
        HomeController() {
        }

        @Autowired
        SiteUserRepository siteUserRepository;
        @Autowired
        PostsRepository postsRepository;

        @GetMapping("/signup")
        public String getSignUpPage() {
            return "signup.html";
        }

        @GetMapping("/home/{username}")
        public String getHome(@PathVariable String username, Model mdl) {
            SiteUser siteUserToView = siteUserRepository.findByUsername(username);
            mdl.addAttribute("username", username.toLowerCase());
            mdl.addAttribute("siteUser", siteUserToView);
            mdl.addAttribute("posts", siteUserToView.getPostsList());
            return "homepage.html";
        }

        @PostMapping("/add-post")
        public RedirectView addPost(long siteUserId, String text) {
            SiteUser siteUser = siteUserRepository.getReferenceById(siteUserId);
            Posts postsToAdd = new Posts(text);
            postsToAdd.setSiteUser(siteUser);
            postsRepository.save(postsToAdd);
            String username = siteUser.getUsername();

            return new RedirectView("/home/" + username);
        }
    }