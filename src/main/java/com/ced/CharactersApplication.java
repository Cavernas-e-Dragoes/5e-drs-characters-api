package com.ced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.ced.unutils.DiceBannerGenerator.generateBanner;

@SpringBootApplication
public class CharactersApplication {

    public static void main(String[] args) {
        generateBanner();
        SpringApplication.run(CharactersApplication.class, args);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
