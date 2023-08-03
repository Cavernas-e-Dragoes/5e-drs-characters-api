package com.ced.users.repository;

import com.ced.users.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Integer> {

    public Optional<User> findByEmail(String email);

}
