package ua.com.maist.service.authentication;


import ua.com.maist.model.entity.User;

public interface AuthenticationService {

    User saveUser(User user);

    void activateUser(User user);

}
