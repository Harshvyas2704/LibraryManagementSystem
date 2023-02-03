package com.libraryManagement.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManagement.exceptions.UserException;
import com.libraryManagement.model.Book;
import com.libraryManagement.model.User;
import com.libraryManagement.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//v
	@PostMapping("/api/user/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserException {
		
		User newUser = userService.addUser(user);
		
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);	
	}
	
	@PutMapping("/api/user/update/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Integer userId) throws UserException{
		User updatedUser = userService.updateUser(user, userId);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);	
	}
	
	//v
	@DeleteMapping("/api/user/delete/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable("userId") Integer userId)
			throws UserException {

		User deletedUser = userService.deleteUser(userId);

		return new ResponseEntity<User>(deletedUser, HttpStatus.OK);

	}
	
	
	@PutMapping("/api/user/borrow/{userId}/{bookId}")
	public ResponseEntity<String> borrowBook(@PathVariable("userId") Integer userId, @PathVariable("bookId") Integer bookId) throws UserException {
		
		String str = userService.borrowBook(userId, bookId);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
		
	}
	
	@PutMapping("/api/user/return/{issueId}")
	public ResponseEntity<String> returnBook(@PathVariable("issueId") Integer issueId) throws UserException, ParseException {
		
		String str = userService.returnBook(issueId);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
		
	}
	
	@PostMapping("/book/add")
	public ResponseEntity<Book> addBook(@RequestBody Book book) throws UserException {
		
		Book newBook = userService.addBook(book);
		
		return new ResponseEntity<Book>(newBook, HttpStatus.CREATED);	
	}
}
