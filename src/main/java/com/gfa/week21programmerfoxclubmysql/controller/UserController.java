package com.gfa.week21programmerfoxclubmysql.controller;

import com.gfa.week21programmerfoxclubmysql.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.NameAlreadyBoundException;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRegistrationService userRegistrationService;

    @GetMapping("/register")
    public String registerUser() {
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistrationFormUser(@RequestParam String username,
                                             @RequestParam String password,
                                             @RequestParam String password2,
                                             RedirectAttributes redirectAttributes) {
        if (!password.equals(password2)) {
            redirectAttributes.addFlashAttribute("errorPassword", "Passwords do not match! Please, try again.");
            return "redirect:/register";
        }
        try {
            userRegistrationService.registerNewUser(username, password);
            return "redirect:/login";
        } catch (NameAlreadyBoundException e) {
            redirectAttributes.addFlashAttribute("errorUsername", "Username is already taken! Please, try another name.");
            return "redirect:/register";
        }
}

    @GetMapping("/logout")
    public String logout(Authentication authentication) {
        authentication.setAuthenticated(false);
        return "redirect:/login";
    }
}
