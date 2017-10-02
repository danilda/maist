package ua.com.maist.service;


import ua.com.maist.model.entity.User;


public interface UserService {
    User findUserByLogin(String login);

    void saveUser(User user);
}
