package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;
    
    @Autowired
    BlogService blogService;

    public User createUser(String username, String password){

    	User user= new User();

    	userRepository3.save(user);
    	return user;
    }

    public void deleteUser(int userId){

    	User user= userRepository3.findById(userId).orElse(null);
    	userRepository3.deleteById(userId);
    	if(user==null) {
    		return;
    	}
    	
    }

    public User updateUser(Integer id, String password){
    	User user= userRepository3.findById(id).orElse(null);
    	if(user==null) {
    		return null;
    	}
    	userRepository3.deleteById(id);
    	user.setPassword(password);
    	userRepository3.save(user);
    	return user;
    	
    }
}
