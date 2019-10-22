package com.slug.sec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slug.sec.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
}
