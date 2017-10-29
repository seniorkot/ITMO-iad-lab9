package com.seniorkot.controller;

import com.seniorkot.model.User;
import com.seniorkot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user.get", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @RequestMapping(value = "/user.signup", method = RequestMethod.POST)
    public User signUp(@RequestParam(name = "login", required = true) String login,
                       @RequestParam(name = "passwd", required = true) String passwd,
                       @RequestParam(name = "email", required = true) String email){

        passwd = String.valueOf(passwd.hashCode());

        User user = userService.getByLogin(login);
        if (user != null){
            return user;
        }

        user = new User(login, passwd, email);
        userService.add(user);
        return user;
    }

    @RequestMapping(value = "/user.signin", method = RequestMethod.GET)
    public User signIn(@RequestParam(name = "login", required = true) String login,
                       @RequestParam(name = "passwd", required = true) String passwd){
        passwd = String.valueOf(passwd.hashCode());
        return userService.getByLoginAndPassword(login, passwd);
    }
}
