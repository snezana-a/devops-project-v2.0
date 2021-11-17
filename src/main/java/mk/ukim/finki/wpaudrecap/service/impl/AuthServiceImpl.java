package mk.ukim.finki.wpaudrecap.service.impl;

import mk.ukim.finki.wpaudrecap.model.User;
import mk.ukim.finki.wpaudrecap.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.wpaudrecap.model.exceptions.InvalidUsernameCredentialsException;
import mk.ukim.finki.wpaudrecap.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.wpaudrecap.repository.InMemoryUserRepository;
import mk.ukim.finki.wpaudrecap.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final InMemoryUserRepository userRepository;

    public AuthServiceImpl(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            throw new InvalidArgumentException();
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUsernameCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentException();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }
        User user = new User(username, password, name, surname);
        return userRepository.saveOrUpdate(user);
    }
}
