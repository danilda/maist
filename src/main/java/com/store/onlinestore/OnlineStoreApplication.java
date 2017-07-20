package com.store.onlinestore;

import com.store.onlinestore.model.entity.User;
import com.store.onlinestore.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.h2.tools.Server;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@SpringBootApplication
@Configuration
//@ImportResource({"./context.xml"})
public class OnlineStoreApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OnlineStoreApplication.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}


		UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
		User user = userRepository.findByLogin("admin");
		System.out.println(user.toString());
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9093");
	}

}
