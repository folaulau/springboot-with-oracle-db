package com.folautech.oracle.repository;

import com.folautech.oracle.entity.Customer;
import com.folautech.oracle.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
