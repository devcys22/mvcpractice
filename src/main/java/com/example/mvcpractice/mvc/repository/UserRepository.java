package com.example.mvcpractice.mvc.repository;

import com.example.mvcpractice.mvc.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static Map<String, User> users = new HashMap<>();

    public static void save(User user){
        users.put(user.getUserId(), user);
    }
}
