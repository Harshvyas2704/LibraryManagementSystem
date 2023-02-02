package com.libraryManagement.service;

import java.util.List;

import com.libraryManagement.model.Book;
import com.libraryManagement.model.User;

public interface UserService {
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public boolean deleteUser(Integer userId);
	
	public List<Book> issuedBooks(Integer userId);
	
	public boolean bookAvailability(Integer bookId);

}
