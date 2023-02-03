package com.libraryManagement.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagement.exceptions.UserException;
import com.libraryManagement.model.Book;
import com.libraryManagement.model.User;
import com.libraryManagement.model.User_Book;
import com.libraryManagement.repository.BookRepo;
import com.libraryManagement.repository.UserBookRepo;
import com.libraryManagement.repository.UserRepo;
import com.libraryManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {
		
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private UserBookRepo ubRepo;
	
	@Override
	public User addUser(User user) throws UserException {
		
		User u1=userRepo.findUserByMobile(user.getMobileNumber());
		
		if(u1==null)
		{			
			User addedUser  = userRepo.save(user);
			return addedUser;
		}else {
			throw new UserException("user already existing with this phon number");
		}
		
		// pending to check existing user
		
		
		
		
		
	}

	@Override
	public User updateUser(User user, Integer userId) throws UserException {
		
		Optional<User> u = userRepo.findById(userId);
		
		if(u != null) {
			
			userRepo.save(user);
			return user;
		}
		else {
			
			throw new UserException("No user found on Id " + user.getUserId());
			
		}
		
	}

	@Override
	public User deleteUser(Integer userId) throws UserException {
		
		Optional<User> u = userRepo.findById(userId);
		if(u.isPresent()) {
			
			userRepo.delete(u.get());
			return u.get();
			
		}
		else {
			
			throw new UserException("No user found on Id " + userId);
			
		}
		
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

	@Override
	public String borrowBook(Integer userId, Integer bookId) throws UserException {
		
		Optional<User> user = userRepo.findById(userId);
		Optional<Book> book = bookRepo.findById(bookId);
		
		Book b = book.get();
		User u = user.get();
		
		if(b.getNoOfCopyAvailable() > 1 && u.getNumberOfBooks() < 5 && u.getFine() == 0) {
			
			User_Book ub = new User_Book(LocalDate.now(), LocalDate.now().plusDays(30), null, u, b);
			
			b.setNoOfCopyAvailable(b.getNoOfCopyAvailable() - 1);
			u.setNumberOfBooks(u.getNumberOfBooks() + 1);
			
			bookRepo.save(b);
			userRepo.save(u);
			
			ubRepo.save(ub);
			
			return "Book borrowed successfully";
			
			
		}
		
		else {
			
			throw new UserException("No user found on Id : " + userId);
			// elif if book ! ava then new excp
			// max 5 books
			
			
		}
		
		
		
	}

	@Override
	public String returnBook(Integer issueNumber) throws UserException, ParseException {
		
		Optional<User_Book> ub = ubRepo.findById(issueNumber);
		
		User_Book u = ub.get();
		
		Optional<User> user = userRepo.findById(u.getUser().getUserId());
		Optional<Book> book = bookRepo.findById(u.getBook().getSerialNumber());
		
		Book b = book.get();
		User uu = user.get();
		
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 
		 
		 Date d1 = sdf.parse(u.getIssuedDate().toString());
         Date d2 = sdf.parse(LocalDate.now().toString());
		 
//		Duration diff = Duration.between(u.getIssuedDate(), LocalDate.now());
//		
//		int d=(int) (diff.getSeconds()/(60*60*24));
		
         long time_difference = d2.getTime() - d1.getTime();  
         // Calucalte time difference in days  
         long dd = (time_difference / (1000*60*60*24)) % 365;   
         
         
		if( dd> 30) {
			
			int penalty = (int) ((dd - 30) * 50);
			uu.setFine(uu.getFine() + penalty);
			
			
			userRepo.save(uu);
			
		}
		
		
		b.setNoOfCopyAvailable(b.getNoOfCopyAvailable() + 1);
		uu.setNumberOfBooks(uu.getNumberOfBooks() - 1);
		
		bookRepo.save(b);
		userRepo.save(uu);
		
		ubRepo.delete(ub.get());
		
		
		return "Book returned successfully,and your fine is : "+uu.getFine();
		
		
	}

	@Override
	public Book addBook(Book book) throws UserException {
		// TODO Auto-generated method stub
     Book b1=bookRepo.findBookByName(book.getBookName());
		if(b1==null)
		{			
			Book addedBook  = bookRepo.save(book);
			return addedBook;
		}else {
			throw new UserException("A book is already existing with this name");
		}
		
	}
	
	

}
