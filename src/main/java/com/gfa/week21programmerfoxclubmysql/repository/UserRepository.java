package com.gfa.week21programmerfoxclubmysql.repository;

import com.gfa.week21programmerfoxclubmysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String name);
}
