package com.tfs.oneTest4.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    //Optional<User> findUserByName(String name);
    //@Query(" can use a raw query here")
    User findByEmail(String email);
}
