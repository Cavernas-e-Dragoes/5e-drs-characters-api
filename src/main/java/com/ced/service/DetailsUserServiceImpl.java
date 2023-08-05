package com.ced.service;

import com.ced.data.DetailsUserDate;
import com.ced.model.User;
import com.ced.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetailsUserServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public DetailsUserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(email);
        if(user.isEmpty()) {
            throw new UsernameNotFoundException("Email " + email + " não encontrado.");
        }

        return new DetailsUserDate(user);
    }
}
