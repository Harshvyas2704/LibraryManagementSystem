package com.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagement.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
