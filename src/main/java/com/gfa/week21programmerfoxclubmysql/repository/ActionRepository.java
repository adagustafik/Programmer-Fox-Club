package com.gfa.week21programmerfoxclubmysql.repository;

import com.gfa.week21programmerfoxclubmysql.model.Action;
import com.gfa.week21programmerfoxclubmysql.model.Fox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

    List<Action> findAllByFoxOrderByAddedDesc(Fox fox);
}
