package com.gfa.week21programmerfoxclubmysql.controller;

import com.gfa.week21programmerfoxclubmysql.model.Fox;
import com.gfa.week21programmerfoxclubmysql.model.Trick;
import com.gfa.week21programmerfoxclubmysql.service.FoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class TricksController {

    private final FoxService foxService;

    @GetMapping("/trickCenter")
    public String showTricks(Model model) {
        Fox fox = foxService.getSelectedFox();
        if (Objects.nonNull(fox)) {
            model.addAttribute("fox", fox);
            model.addAttribute("tricks", Trick.values());
            return "features";
        }
        return "redirect:/";
    }

    @PostMapping("/trickCenter")
    public String learnTricks(@RequestParam String trick) {
        if (Objects.nonNull(foxService.learnFoxTricks(trick))) {
            return "redirect:/information";
        }
        return "redirect:/";
    }
}
