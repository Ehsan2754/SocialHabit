package com.socialhabit.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserEntityRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new UserEntity("AlexDest", "12345")));
            log.info("Preloading " + repository.save(new UserEntity("Kedavr", "123456789")));
        };
    }
}
