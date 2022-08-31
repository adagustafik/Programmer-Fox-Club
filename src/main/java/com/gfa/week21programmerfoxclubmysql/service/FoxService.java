package com.gfa.week21programmerfoxclubmysql.service;

import com.gfa.week21programmerfoxclubmysql.model.Fox;
import com.gfa.week21programmerfoxclubmysql.model.User;

import java.util.List;

public interface FoxService {
    List<Fox> getFoxesByUser(User user);
    Fox selectFox(String name, User user);
    Fox switchFox(long id);
    Fox getSelectedFox();
    Fox changeFoxNutrition(String food, String drink);
    Fox learnFoxTricks(String trick);
}
