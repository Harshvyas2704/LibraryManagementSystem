package com.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.libraryManagement.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

	@Query("from Book b where b.bookName=?1")
	public Book findBookByName(String name);
	
}
