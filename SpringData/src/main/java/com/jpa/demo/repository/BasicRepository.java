package com.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface BasicRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
