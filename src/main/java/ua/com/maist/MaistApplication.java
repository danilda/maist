package ua.com.maist;

import ua.com.maist.model.entity.Item;
import ua.com.maist.model.entity.Order;
import ua.com.maist.model.entity.Role;
import ua.com.maist.model.entity.User;
import ua.com.maist.model.repositories.*;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
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
        listAdmin.add(roleRepository.findOne((long) 0));
        Set<Role> listUser = new HashSet<>();
        listUser.add(roleRepository.findOne((long) 1));
        listAdmin.forEach(e -> log.info(e.toString()));
        listUser.forEach(e -> log.info(e.toString()));

        UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");

        User admin = userRepository.findByLogin("admin");
        User user = userRepository.findByLogin("user");
        log.info(admin.toString());
        log.info(user.toString());
        log.info("-----------");

        OrderRepository orderRepository = (OrderRepository) ctx.getBean("orderRepository");
        orderRepository.findByUser(user).forEach(e -> log.info(e.toString()));
        log.info("-----------");

        ItemTypeRepository itemTypeRepository = (ItemTypeRepository) ctx.getBean("itemTypeRepository");
        itemTypeRepository.findAll().forEach(e -> log.info(e.toString()));
        itemTypeRepository.findByParent(itemTypeRepository.getOne((long) 0)).forEach(e -> log.info(e.toString()));
        itemTypeRepository.getOne((long) 0).getItemAttributes().forEach(e -> log.info("Item -> " + e.toString()));
        log.info("-----------");

        ItemAttributeRepository itemAttributeRepository = (ItemAttributeRepository) ctx.getBean("itemAttributeRepository");
        itemAttributeRepository.findAll().forEach(e -> log.info(e.toString()));
        log.info("Find item attribute by Name -> " + itemAttributeRepository.findByName("Consist"));
        itemAttributeRepository.getOne((long) 0).getItemTypes().forEach(e -> log.info("Made in -> " + e.toString()));
        itemAttributeRepository.findByItemTypes(itemTypeRepository.getOne((long) 1))
                .forEach(e -> log.info("All attributes of Food" + e.toString()));
        log.info("-----------");

        ItemRepository itemRepository = (ItemRepository) ctx.getBean("itemRepository");
        itemRepository.findAll().forEach(log::info);
        log.info(itemRepository.findByItemType(itemTypeRepository.getOne((long) 1)));
        itemRepository.findAll().forEach(item -> item.getProperties().forEach(e -> log.info(item.getName() + " " + e.toString())));
        log.info("-----------");

        ItemPropertyRepository itemPropertyRepository = (ItemPropertyRepository) ctx.getBean("itemPropertyRepository");
        itemPropertyRepository.findAll().forEach(log::info);
        log.info("-----------");

        OrderItemRepository orderItemRepository = (OrderItemRepository) ctx.getBean("orderItemRepository");
        orderItemRepository.findAll().forEach(log::info);
        log.info("Find OrderItem By Item -> " + orderItemRepository.findByItem(itemRepository.getOne((long) 1)).toString());
    }

}
