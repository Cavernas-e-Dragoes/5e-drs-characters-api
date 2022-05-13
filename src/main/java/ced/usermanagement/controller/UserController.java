package ced.usermanagement.controller;

import ced.usermanagement.helper.JwtHelper;
import ced.usermanagement.model.User;
import ced.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api/user")
public class UserController {

    private final PasswordEncoder encoder;
    private final UserRepository repository;

    @Autowired
    public UserController(PasswordEncoder encoder, UserRepository repository) {
        this.encoder = encoder;
        this.repository = repository;
    }

    @GetMapping("/")
    public String version(){
        return "1.0.2";
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
    }

    @GetMapping("/userData")
    public ResponseEntity<User> getUserData(@RequestHeader(value = "Authorization", required = false) final String authorization) {

        Optional<User> user = repository.findByLogin(JwtHelper.findUser(authorization));
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user.get());
        }
        return ResponseEntity.status(HttpStatus.OK).body(user.get());

    }
}
