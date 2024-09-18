package com.folautech.oracle.repository;

import com.folautech.oracle.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
