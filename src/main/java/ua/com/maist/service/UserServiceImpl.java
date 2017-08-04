package ua.com.maist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.maist.model.entity.Role;
import ua.com.maist.model.entity.User;
import ua.com.maist.model.repositories.RoleRepository;
import ua.com.maist.model.repositories.UserRepository;
import ua.com.maist.service.UserService;

import java.util.Collections;
import java.util.HashSet;

/**
 * Created by dach1016 on 29.07.2017.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Value("${user.default-role-value}")
    private String defaultRole;

    @Override
    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    /*

        TODO - активировать аккаунт после специальным письмом на почту

      */
    @Override
    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setActive(1);
        user.setVersion(1);
        user.setConfirmPassword(user.getPassword()); // in encoding process two equal become no equal.
        Role role = roleRepository.findByRole(defaultRole);
        user.setRoles(new HashSet<>(Collections.singletonList(role)));
        userRepository.save(user);
    }
}
