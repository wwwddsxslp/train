package com.example.train;


import com.example.train.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty extends JpaRepository<User,Integer> {

}
