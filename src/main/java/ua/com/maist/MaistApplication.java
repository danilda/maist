package ua.com.maist;

import ua.com.maist.model.entity.Order;
import ua.com.maist.model.entity.Role;
import ua.com.maist.model.entity.User;
import ua.com.maist.model.repositories.OrderRepository;
import ua.com.maist.model.repositories.RoleRepository;
import ua.com.maist.model.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@SpringBootApplication
@Configuration
public class MaistApplication extends SpringBootServletInitializer {
    private static final Logger log = Logger.getLogger(MaistApplication.class);


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MaistApplication.class);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MaistApplication.class, args);


        RoleRepository roleRepository = (RoleRepository) ctx.getBean("roleRepository");
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("USER"));

        Set<Role> listAdmin = new HashSet<>();
        listAdmin.add(roleRepository.findOne(1));
        Set<Role> listUser = new HashSet<>();
        listUser.add(roleRepository.findOne(2));
        listAdmin.forEach(e->log.info(e.toString()));
        listUser.forEach(e->log.info(e.toString()));

        UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");


        User inputUser = new User("admin", "$2a$10$UDvJMPOByqrkGi7Pk3gzBeS/2xgnAL3T/YNxhdbBOehmGJ.Jj4uGu",
                "admin@mail.com", 1, listAdmin, "admin", "adminovich", "+380660011001");

        inputUser.setConfirmPassword("$2a$10$UDvJMPOByqrkGi7Pk3gzBeS/2xgnAL3T/YNxhdbBOehmGJ.Jj4uGu");
        userRepository.save(inputUser);

        inputUser = new User("user", "$2a$10$jc4IZXkr3nrmbmQZNlVHpuaGdro/I4SjThww9BbGRk4PdHNOiUGvC",
                "user@mail.com", 1, listUser, "user", "userovich", "+380660011002");
        inputUser.setConfirmPassword("$2a$10$jc4IZXkr3nrmbmQZNlVHpuaGdro/I4SjThww9BbGRk4PdHNOiUGvC");
        userRepository.save(inputUser);


        User admin = userRepository.findByLogin("admin");
        User user = userRepository.findByLogin("user");
        log.info(admin.toString());
        log.info(user.toString());

        Order inputOrder = new Order(user, new Date(), 666);
        OrderRepository orderRepository = (OrderRepository) ctx.getBean("orderRepository");
        orderRepository.save(inputOrder);

        Order order = orderRepository.findOne(1);
        log.info(order.toString());

    }

}
