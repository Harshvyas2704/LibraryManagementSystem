package com.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagement.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
