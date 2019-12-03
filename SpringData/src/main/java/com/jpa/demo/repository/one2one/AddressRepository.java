package com.jpa.demo.repository.one2one;

import com.jpa.demo.model.one2one.Address;
import com.jpa.demo.repository.BasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends BasicRepository<Address, Long> {

}
