package com.store.onlinestore;

import com.store.onlinestore.model.entity.User;
import com.store.onlinestore.model.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.h2.tools.Server;
import org.springframework.context.annotation.Configuration;
import java.sql.SQLException;

@SpringBootApplication
@Configuration
public class OnlineStoreApplication extends SpringBootServletInitializer {
	private static final Logger log = Logger.getLogger(OnlineStoreApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OnlineStoreApplication.class);
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OnlineStoreApplication.class, args);

		UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
		User admin = userRepository.findByLogin("admin");
		User user = userRepository.findByLogin("user");

		System.out.println("aaaaaaa");
		System.out.println(user.toString());
		System.out.println(admin.toString());
		log.info(user.toString());

	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9093");
	}

}
