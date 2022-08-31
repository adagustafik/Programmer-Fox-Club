package com.gfa.week21programmerfoxclubmysql.repository;

import com.gfa.week21programmerfoxclubmysql.model.Fox;
import com.gfa.week21programmerfoxclubmysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoxRepository extends JpaRepository<Fox, Long> {

    Fox findByNameIgnoreCaseAndUser(String name, User user);
    List<Fox> findAllByUser(User user);
}
