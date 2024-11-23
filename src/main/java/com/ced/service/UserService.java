package com.ced.service;

import com.ced.data.DetailsUserDate;
import com.ced.dto.UserDTO;
import com.ced.model.User;
import com.ced.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public UserDTO userCreate(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return new UserDTO(user.getEmail());
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Email " + email + " não encontrado.");
        }

        return new DetailsUserDate(user);
    }

}
