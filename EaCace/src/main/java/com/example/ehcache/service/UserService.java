package com.example.ehcache.service;

import com.example.ehcache.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User findUserById(Long id);

    public List<User> findAllUser();

    public void saveAndFlush(User user);

    public void deleteUserById(Long id);

}
