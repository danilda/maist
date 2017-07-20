package com.store.onlinestore.model.repositories;

import com.store.onlinestore.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dach1016 on 20.07.2017.
 *
 */


public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);
}
