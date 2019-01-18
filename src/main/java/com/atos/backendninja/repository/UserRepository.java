package com.atos.backendninja.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.backendninja.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {


	public User findByUsername(String username);
}
