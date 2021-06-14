package com.upload_image.controllers;

import com.upload_image.models.User;
import com.upload_image.repositories.UserRepository;
import com.upload_image.utils.Credentials;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class LoginController {
    private final UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Credentials credentials) {
        ModelAndView mv;
        User user = userRepository.findByEmailAndPassword(
                credentials.getEmail(),
                credentials.getPassword());

        if (user != null) {
            mv = new ModelAndView("profile");
            mv.addObject("user", user);
        } else {
            mv = new ModelAndView("login");
        }

        return mv;
    }

}
