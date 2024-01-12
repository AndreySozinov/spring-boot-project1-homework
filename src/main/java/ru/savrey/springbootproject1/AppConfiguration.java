package ru.savrey.springbootproject1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfiguration {

    @Bean
    UserRepository myUserRepository() {
        return new UserRepository();
    }
}
