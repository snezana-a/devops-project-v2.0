package mk.ukim.finki.wpaudrecap.service.impl;

import mk.ukim.finki.wpaudrecap.model.User;
import mk.ukim.finki.wpaudrecap.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.wpaudrecap.model.exceptions.InvalidUsernameCredentialsException;
import mk.ukim.finki.wpaudrecap.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.wpaudrecap.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.wpaudrecap.repository.impl.InMemoryUserRepository;
import mk.ukim.finki.wpaudrecap.repository.jpa.UserRepository;
import mk.ukim.finki.wpaudrecap.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            throw new InvalidArgumentException();
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUsernameCredentialsException::new);
    }

}
