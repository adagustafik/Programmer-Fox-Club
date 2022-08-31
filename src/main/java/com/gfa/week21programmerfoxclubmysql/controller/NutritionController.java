package com.gfa.week21programmerfoxclubmysql.controller;

import com.gfa.week21programmerfoxclubmysql.model.Drink;
import com.gfa.week21programmerfoxclubmysql.model.Food;
import com.gfa.week21programmerfoxclubmysql.model.Fox;
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
public class NutritionController {

    private final FoxService foxService;

    @GetMapping("/nutritionStore")
    public String showNutritions(Model model) {
        Fox fox = foxService.getSelectedFox();
        if (Objects.nonNull(fox)) {
            model.addAttribute("fox", fox);
            model.addAttribute("foods", Food.values());
            model.addAttribute("drinks", Drink.values());
            return "features";
        }
        return "redirect:/";
    }

    @PostMapping("/nutritionStore")
    public String setNutritions(@RequestParam String food, @RequestParam String drink) {
        if (Objects.nonNull(foxService.changeFoxNutrition(food, drink))) {
            return "redirect:/information";
        }
        return "redirect:/";
    }
}
