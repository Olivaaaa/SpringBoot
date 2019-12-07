package com.jpa.demo.repository.one2many;


import com.jpa.demo.model.one2mamy.department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface departmentRepository extends JpaRepository<department, Long> {

}
