package com.seniorkot.service;

import com.seniorkot.repository.UserRepository;
import com.seniorkot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void add(User user){
        userRepository.saveAndFlush(user);
    }

    public void delete(long id){
        userRepository.delete(id);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }

    public User getByLogin(String login){
        return userRepository.findOneByLogin(login);
    }

    public User getByLoginAndPassword(String login, String passwd){
        return userRepository.findOneByLoginAndPassword(login, passwd);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
