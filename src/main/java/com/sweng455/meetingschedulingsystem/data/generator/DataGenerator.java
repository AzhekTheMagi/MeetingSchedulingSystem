package com.sweng455.meetingschedulingsystem.data.generator;

import com.sweng455.meetingschedulingsystem.data.entity.Role;
import com.sweng455.meetingschedulingsystem.data.entity.User;
import com.sweng455.meetingschedulingsystem.data.repository.UserRepository;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringComponent
public class DataGenerator {
    @Bean
    public CommandLineRunner loadData(UserRepository userRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (userRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            /*
            logger.info("... generating 5 Person entities...");
            ExampleDataGenerator<User> userRepositoryGenerator = new ExampleDataGenerator<>(User.class);
            userRepositoryGenerator.setData(User::setId, DataType.ID);
            userRepositoryGenerator.setData(User::setFirstName, DataType.FIRST_NAME);
            userRepositoryGenerator.setData(User::setLastName, DataType.LAST_NAME);
            userRepositoryGenerator.setData(User::setEmail, DataType.EMAIL);
            userRepository.saveAll(userRepositoryGenerator.create(5, seed));
             */

            userRepository.save(new User("user", "user", Role.USER));
            userRepository.save(new User("admin", "admin", Role.ADMIN));

            userRepository.save(new User("smith1984", "user", Role.USER));
            userRepository.save(new User("doe1984", "admin", Role.ADMIN));

            logger.info("Generated demo data");
        };
    }
}
