package com.ced.service;

import com.ced.data.DetailsUserDate;
import com.ced.dto.UserDTO;
import com.ced.model.MessageRequest;
import com.ced.model.User;
import com.ced.repository.UserRepository;
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
    private final MessageService messageService;

    public UserService(final UserRepository repository, final PasswordEncoder encoder,
                       final MessageService messageService) {
        this.repository = repository;
        this.encoder = encoder;
        this.messageService = messageService;
    }

    public UserDTO userCreate(final User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        sendMail(user);
        return new UserDTO(user.getEmail());
    }

    private void sendMail(final User user) {
        MessageRequest message = new MessageRequest();
        message.setTo(user.getEmail());
        message.setSubject("Bem-vindo ao Cavernas e Dragões!");
        message.setMessage("Olá " + user.getName() + ", sua jornada no Cavernas e Dragões começa agora! Prepare-se para aventuras épicas.");
        message.setChannel("email");
        messageService.sendMessage(message);
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Email " + email + " not found.");
        }
        return new DetailsUserDate(user);
    }
}