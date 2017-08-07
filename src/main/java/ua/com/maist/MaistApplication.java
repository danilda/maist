package ua.com.maist;

import ua.com.maist.model.entity.Order;
import ua.com.maist.model.entity.Role;
import ua.com.maist.model.entity.User;
import ua.com.maist.model.repositories.ItemTypeRepository;
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

        Set<Role> listAdmin = new HashSet<>();
        listAdmin.add(roleRepository.findOne((long)0));
        Set<Role> listUser = new HashSet<>();
        listUser.add(roleRepository.findOne((long)1));
        listAdmin.forEach(e -> log.info(e.toString()));
        listUser.forEach(e -> log.info(e.toString()));

        UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");

        User admin = userRepository.findByLogin("admin");
        User user = userRepository.findByLogin("user");
        log.info(admin.toString());
        log.info(user.toString());

        OrderRepository orderRepository = (OrderRepository) ctx.getBean("orderRepository");

        orderRepository.findByUser(user).forEach(e -> log.info(e.toString()));
//
//        ItemTypeRepository itemTypeRepository = (ItemTypeRepository)ctx.getBean("itemTypeRepository");
//        itemTypeRepository.

    }

}
