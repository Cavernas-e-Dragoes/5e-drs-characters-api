package com.ced.security;

import com.ced.repository.UserRepository;
import com.ced.service.DetailsUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class JWTConfig  {

    public static final String ALLOWED_ORIGIN_CAVE_DRAGONS = System.getenv("ALLOWED_ORIGIN_CAVE_DRAGONS");
    public static final String ALLOWED_ORIGIN_LOCALHOST = System.getenv("ALLOWED_ORIGIN_LOCALHOST");

    @Autowired
    private DetailsUserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final AuthenticationConfiguration configuration;

    @Autowired
    public JWTConfig(AuthenticationConfiguration configuration) {
        this.configuration = configuration;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/v1/api/user/**").permitAll()
                        .requestMatchers("/v1/api/characters/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .anyRequest().authenticated()

                )
                .addFilter(new JWTAuthFilter(configuration.getAuthenticationManager(), userRepository))
                .addFilter(new JWTValidFilter(configuration.getAuthenticationManager()))
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
