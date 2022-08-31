package com.gfa.week21programmerfoxclubmysql.service;

import com.gfa.week21programmerfoxclubmysql.model.Action;
import com.gfa.week21programmerfoxclubmysql.model.Fox;
import com.gfa.week21programmerfoxclubmysql.repository.ActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ActionServiceImpl implements ActionService {

    private final ActionRepository actionRepository;

    @Override
    public Action addAction(Action action) {
        return actionRepository.save(action);
    }

    @Override
    public List<Action> actionsByFox(Fox fox) {
        return actionRepository.findAllByFoxOrderByAddedDesc(fox);
    }
}
