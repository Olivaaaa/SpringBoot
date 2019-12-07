package com.jpa.demo.repository.one2many;

import com.jpa.demo.model.one2mamy.company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface companyRepository extends JpaRepository<company, Long> {

}
