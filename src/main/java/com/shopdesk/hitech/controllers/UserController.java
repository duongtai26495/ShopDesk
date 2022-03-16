package com.shopdesk.hitech.controllers;

import com.shopdesk.hitech.entities.ResponseObject;
import com.shopdesk.hitech.entities.User;
import com.shopdesk.hitech.entities.UserDTO;
import com.shopdesk.hitech.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("register")
    public ResponseEntity<ResponseObject> CreateUser (@RequestBody User user){
        return userService.saveUser(user);
    }


    @GetMapping("all")
    public ResponseEntity<ResponseObject> GetAll (){
        return userService.getAll();
    }
}

