package fi.antti.varaus.service;

import fi.antti.varaus.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}