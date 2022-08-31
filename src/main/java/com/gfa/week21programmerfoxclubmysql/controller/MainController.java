package com.gfa.week21programmerfoxclubmysql.controller;

import com.gfa.week21programmerfoxclubmysql.model.User;
import com.gfa.week21programmerfoxclubmysql.service.FoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final FoxService foxService;

    @GetMapping
    public String showMain(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("foxes", foxService.getFoxesByUser(user));
        return "index";
    }
}
