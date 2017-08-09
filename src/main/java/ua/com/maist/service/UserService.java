package ua.com.maist.service;

import ua.com.maist.model.entity.User;

/**
 * Created by dach1016 on 29.07.2017.
 */
public interface UserService {
    User findUserByLogin(String login);

    void saveUser(User user);
}
