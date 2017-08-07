package ua.com.maist.model.repositories;

import ua.com.maist.model.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dach1016 on 20.07.2017.
 */


public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);
}
