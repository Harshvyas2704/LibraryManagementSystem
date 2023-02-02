package com.libraryManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagement.model.Book;
import com.libraryManagement.model.User;
import com.libraryManagement.repository.UserRepo;
import com.libraryManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {
		
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User addUser(User user) {
		
		User addedUser  = userRepo.save(user);
		// pending to check existing user
		
		return addedUser;
		
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> issuedBooks(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bookAvailability(Integer bookId) {
		// TODO Auto-generated method stub
		return false;
	}

}
