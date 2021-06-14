package com.upload_image.controllers;

import com.upload_image.models.User;
import com.upload_image.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(User user) {
        userRepository.save(user);
        return "redirect:/login";
    }
}
