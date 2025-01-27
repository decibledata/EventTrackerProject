package com.skilldistillery.bunker.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.User;
import com.skilldistillery.bunker.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(int id, User user) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
