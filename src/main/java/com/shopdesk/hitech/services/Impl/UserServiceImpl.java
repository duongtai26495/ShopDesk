package com.shopdesk.hitech.services.Impl;

import com.shopdesk.hitech.entities.ConvertUserDTO;
import com.shopdesk.hitech.entities.ResponseObject;
import com.shopdesk.hitech.entities.User;
import com.shopdesk.hitech.entities.UserDTO;
import com.shopdesk.hitech.repositories.RoleRepository;
import com.shopdesk.hitech.repositories.UserRepository;
import com.shopdesk.hitech.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String USER_ROLE = "ROLE_USER";

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public ResponseEntity<ResponseObject> saveUser(User user) {
        if (findByEmail(user.getEmail()).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("FAILED","This email is already taken!",null)
            );
        }
        if (findByUsername(user.getUsername()).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("FAILED","This username is already taken!",null)
            );
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy_hhmmss");
        user.setJoinedAt(sdf.format(date));
        user.setLastEditAt(sdf.format(date));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        user.setRole(roleRepository.findByRole(USER_ROLE));
        userRepository.save(user);
        UserDTO userDTO = ConvertUserDTO.ConvertUser(user);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("SUCCESSFULLY","Create new user success",userDTO)
        );

    }

    @Override
    public ResponseEntity<ResponseObject> getAll() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: userList) {
            userDTOS.add(ConvertUserDTO.ConvertUser(user));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("SUCCESSFULLY","Get all users",userDTOS)
        );
    }
}
