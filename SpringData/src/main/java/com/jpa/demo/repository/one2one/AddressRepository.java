package com.jpa.demo.repository.one2one;

import com.jpa.demo.model.one2one.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
