package com.gfa.week21programmerfoxclubmysql.service;

import com.gfa.week21programmerfoxclubmysql.model.*;
import com.gfa.week21programmerfoxclubmysql.repository.FoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class FoxServiceImpl implements FoxService {

    private final FoxRepository foxRepository;
    private final AutContextFox autContextFox;
    private final ActionService actionService;

    @Override
    public List<Fox> getFoxesByUser(User user) {
        return foxRepository.findAllByUser(user);
    }

    @Override
    public Fox selectFox(String name, User user) {
        Fox fox = foxRepository.findByNameIgnoreCaseAndUser(name, user);
        if (Objects.isNull(fox)) {
            fox = foxRepository.save(new Fox(name, user));
        }
        autContextFox.setFox(fox);
        return fox;
    }

    @Override
    public Fox getSelectedFox() {
        return autContextFox.getFox();
    }

    @Override
    public Fox switchFox(long id) {
        Fox fox = foxRepository.findById(id).get();
        autContextFox.setFox(fox);
        return fox;
    }

    @Override
    public Fox changeFoxNutrition(String food, String drink) {
        Fox fox = autContextFox.getFox();
        var foodEnum = Food.valueOf(food);
        var drinkEnum = Drink.valueOf(drink);
        if ((!fox.getFood().equals(foodEnum)) || (!fox.getDrink().equals(drinkEnum))) {
            if (!fox.getFood().equals(foodEnum)) {
                fox.setFood(foodEnum);
                actionService.addAction(new Action(fox, foodEnum));
            }
            if (!fox.getDrink().equals(drinkEnum)) {
                fox.setDrink(drinkEnum);
                actionService.addAction(new Action(fox, drinkEnum));
            }
            foxRepository.save(fox);
        }
        return fox;
    }

    @Override
    @Transactional
    public Fox learnFoxTricks(String trick) {
        Fox fox = foxRepository.findById(autContextFox.getFox().getId()).get();
        autContextFox.setFox(fox);
        var trickEnum = Trick.valueOf(trick);
        if (!fox.getTricks().contains(trickEnum)) {
            fox.getTricks().add(trickEnum);
            foxRepository.save(fox);
            actionService.addAction(new Action(fox, trickEnum));
        }
        return fox;
    }
}
