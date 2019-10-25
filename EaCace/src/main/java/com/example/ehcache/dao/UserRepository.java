package com.example.ehcache.dao;

import com.example.ehcache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findById(String id);
}
