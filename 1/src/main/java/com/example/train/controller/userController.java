package com.example.train.controller;

import com.example.train.mapper.UserRepositoty;
import com.example.train.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userController {

    @Autowired
    private UserRepositoty userRepositoty;

    @GetMapping(value = "h",produces = "application/json; charset=utf-8")
    public List<User> getUsers(){
        List<User> list =userRepositoty.findAll();
        return list;
    }
}
