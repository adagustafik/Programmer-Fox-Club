package com.gfa.week21programmerfoxclubmysql.service;

import com.gfa.week21programmerfoxclubmysql.model.User;
import com.gfa.week21programmerfoxclubmysql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.NameAlreadyBoundException;

@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUser(String username, String password) throws NameAlreadyBoundException {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new NameAlreadyBoundException(username);
        }
        User user = new User(username, passwordEncoder.encode(password), true);

        return userRepository.save(user);
    }
}
