package com.gfa.week21programmerfoxclubmysql.controller;

import com.gfa.week21programmerfoxclubmysql.model.Fox;
import com.gfa.week21programmerfoxclubmysql.service.ActionService;
import com.gfa.week21programmerfoxclubmysql.service.FoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class ActionsController {

    private final FoxService foxService;
    private final ActionService actionService;

    @GetMapping("/actionHistory")
    public String showHistory(Model model) {
        Fox fox = foxService.getSelectedFox();
        if (Objects.nonNull(fox)) {
            model.addAttribute("actions", actionService.actionsByFox(fox));
            return "features";
        }
        return "redirect:/";
    }
}
