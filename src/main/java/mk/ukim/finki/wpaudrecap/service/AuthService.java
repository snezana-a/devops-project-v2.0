package mk.ukim.finki.wpaudrecap.service;

import mk.ukim.finki.wpaudrecap.model.User;

public interface AuthService {

    User login(String username, String password);

}
