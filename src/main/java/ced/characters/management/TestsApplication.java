package ced.characters.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static ced.characters.management.helper.Calcs.getProficiencyBonus;

public class TestsApplication {

    public static void main(String[] args) {

        //Test getProficiencyBonus calculations
        for(int i = 1; i<21; i++) {
            System.out.println("Level: " + i + " - Proficiency Bonus: " + getProficiencyBonus(i));
        }

    }
}
