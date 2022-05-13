package ced.usermanagement.service;

import ced.usermanagement.data.DetailsUserDate;
import ced.usermanagement.model.User;
import ced.usermanagement.repository.UserRepository;
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
    public DetailsUserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByLogin(username);
        if(user.isEmpty()) {
            throw new UsernameNotFoundException("Login " + username + " não encontrado.");
        }

        return new DetailsUserDate(user);
    }
}
