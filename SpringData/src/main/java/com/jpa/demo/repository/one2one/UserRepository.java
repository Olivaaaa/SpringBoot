package com.jpa.demo.repository.one2one;

import com.jpa.demo.model.one2one.User;
import com.jpa.demo.repository.BasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BasicRepository<User, Long> {
}
