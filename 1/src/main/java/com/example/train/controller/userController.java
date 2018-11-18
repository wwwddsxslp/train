package com.example.train.controller;

import com.example.train.UserRepositoty;
import com.example.train.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class userController {

    @Autowired
    private UserRepositoty userRepositoty;

    @GetMapping("h")
    public List<User> getUsers(){
        List<User> list = new ArrayList<User>();
        list=userRepositoty.findAll();
        return list;
    }
}
