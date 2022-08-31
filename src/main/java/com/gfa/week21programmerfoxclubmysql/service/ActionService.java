package com.gfa.week21programmerfoxclubmysql.service;

import com.gfa.week21programmerfoxclubmysql.model.Action;
import com.gfa.week21programmerfoxclubmysql.model.Fox;

import java.util.List;

public interface ActionService {

    Action addAction(Action action);
    List<Action> actionsByFox(Fox fox);
}
