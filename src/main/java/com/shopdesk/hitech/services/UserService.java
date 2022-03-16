package com.shopdesk.hitech.services;

import com.shopdesk.hitech.entities.ResponseObject;
import com.shopdesk.hitech.entities.User;
import com.shopdesk.hitech.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    ResponseEntity<ResponseObject> saveUser(User user);

    ResponseEntity<ResponseObject> getAll();
}
