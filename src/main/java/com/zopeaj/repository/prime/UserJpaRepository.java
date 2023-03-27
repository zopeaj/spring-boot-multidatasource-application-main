package com.zopeaj.repository.prime;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zopeaj.model.prime.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, UUID>{
	User findUserByName(String name);
}
