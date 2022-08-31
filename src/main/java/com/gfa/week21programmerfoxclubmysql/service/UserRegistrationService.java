package com.gfa.week21programmerfoxclubmysql.service;

import com.gfa.week21programmerfoxclubmysql.model.User;

import javax.naming.NameAlreadyBoundException;

public interface UserRegistrationService {

    User registerNewUser(String username, String password) throws NameAlreadyBoundException;
}
