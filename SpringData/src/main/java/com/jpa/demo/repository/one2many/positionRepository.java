package com.jpa.demo.repository.one2many;

import com.jpa.demo.model.one2mamy.position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface positionRepository extends JpaRepository<position, Long> {

}
