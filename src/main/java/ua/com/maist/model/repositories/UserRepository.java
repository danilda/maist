package ua.com.maist.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.maist.model.entity.User;

/**
 * Created by dach1016 on 20.07.2017.
 */


public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
