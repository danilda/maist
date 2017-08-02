package com.store.onlinestore.service;

import com.store.onlinestore.model.entity.User;

/**
 * Created by dach1016 on 29.07.2017.
 */
public interface UserService {
    User findUserByLogin(String login);

    void saveUser(User user);
}
