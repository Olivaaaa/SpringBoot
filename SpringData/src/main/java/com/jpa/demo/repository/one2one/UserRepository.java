package com.jpa.demo.repository.one2one;

import com.jpa.demo.model.one2one.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
