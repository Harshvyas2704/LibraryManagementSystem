package com.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagement.model.User_Book;

public interface UserBookRepo extends JpaRepository<User_Book, Integer> {

}
