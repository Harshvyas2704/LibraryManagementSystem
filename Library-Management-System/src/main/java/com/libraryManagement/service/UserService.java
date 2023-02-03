package com.libraryManagement.service;

import java.text.ParseException;
import java.util.List;

import com.libraryManagement.exceptions.UserException;
import com.libraryManagement.model.Book;
import com.libraryManagement.model.User;

public interface UserService {
	
	public User addUser(User user) throws UserException;
	
	
	public User deleteUser(Integer userId) throws UserException;
	
	public User updateUser(User user, Integer userId) throws UserException;
	
	
	////////////////////////////////////////////////////
	
	public Book addBook(Book book)throws UserException;
	
	public List<Book> issuedBooks(Integer userId) throws UserException;
	
	
	
	public boolean bookAvailability(Integer bookId)throws UserException;
	
	public String borrowBook(Integer userId, Integer bookId) throws UserException;
	
	public String returnBook(Integer issueNumber) throws UserException, ParseException;

}
