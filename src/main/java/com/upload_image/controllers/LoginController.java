package com.upload_image.controllers;

import com.upload_image.models.User;
import com.upload_image.repositories.UserRepository;
import com.upload_image.utils.Credentials;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class LoginController {
    private final UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Credentials credentials, Model model) {
        User user = userRepository.findByEmailAndPassword(
                credentials.getEmail(),
                credentials.getPassword());

        if (user != null) {
            model.addAttribute("user", user);
            return "redirect:/profile";
        } else {
            return "redirect:/login";
        }
    }

}
