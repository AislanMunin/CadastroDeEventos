package controller;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public void registerUser(String name, String email, String city) {
        User user = new User(name, email, city);
        users.add(user);
        System.out.println("User registered successfully: " + user.getName());
    }

    public List<User> getUsers() {
        return users;
    }
}
