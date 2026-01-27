package com.spring.Coaching.Management.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Coaching.Management.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmailAndPassword(String email, String password);
}
