package com.gfa.week21programmerfoxclubmysql.controller;

import com.gfa.week21programmerfoxclubmysql.model.Fox;
import com.gfa.week21programmerfoxclubmysql.model.User;
import com.gfa.week21programmerfoxclubmysql.service.ActionService;
import com.gfa.week21programmerfoxclubmysql.service.FoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class FoxController {

    private final FoxService foxService;
    private final ActionService actionService;

    @GetMapping("/information")
    public String showFox(Model model) {
        Fox fox = foxService.getSelectedFox();
        if (Objects.nonNull(fox)) {
            model.addAttribute("fox", fox);
            model.addAttribute("actions", actionService.actionsByFox(fox));
            return "information";
        }
        return "redirect:/";
    }

    @GetMapping("/information/{id}")
    public String switchFox(Model model, @PathVariable long id) {
        Fox fox = foxService.switchFox(id);
        model.addAttribute("fox", fox);
        model.addAttribute("actions", actionService.actionsByFox(fox));
        return "information";
    }

    @GetMapping("/create")
    public String getForm(@ModelAttribute Fox fox) {
        return "create";
    }

    @PostMapping("/create")
    public String handleFormData(@Validated @ModelAttribute Fox fox,
                                 BindingResult bindingResult,
                                 Authentication authentication) {
        if (bindingResult.hasErrors()) {
            return "redirect:/create";
        }
        User user = (User) authentication.getPrincipal();
        foxService.selectFox(fox.getName(), user);
        return "redirect:/information";
    }
}
