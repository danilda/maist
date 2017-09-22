package ua.com.maist.service.authentication;


import org.springframework.stereotype.Service;
import ua.com.maist.model.entity.User;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public void activateUser(User user) {

    }
}
