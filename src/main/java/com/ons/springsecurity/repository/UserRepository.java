package com.ons.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ons.springsecurity.model.User;

@Repository (value = "UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
