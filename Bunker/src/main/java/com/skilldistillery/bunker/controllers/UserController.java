package com.skilldistillery.bunker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bunker.entities.User;
import com.skilldistillery.bunker.services.UserService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id, HttpServletResponse resp) {
    	try {
    		if (userService.deleteById(id)) {
    			resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    		} else {
    			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    		}
    	} catch (Exception e) {
    		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    		e.printStackTrace();
    	}
    }
}
