package com.libraryManagement.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User_Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer issueNumber;
	
//	private Integer userId;
//	
//	private Integer serialNumber;
	
	private LocalDate issuedDate;
	
	private LocalDate dueDate;
	
	private LocalDate returnDate;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Book book;

	public User_Book(Integer issueNumber, LocalDate issuedDate, LocalDate dueDate, LocalDate returnDate, User user, Book book) {
		super();
		this.issueNumber = issueNumber;
		this.issuedDate = issuedDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.user = user;
		this.book = book;
	}

	public User_Book() {
		super();
	}

	public Integer getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(Integer issueNumber) {
		this.issueNumber = issueNumber;
	}

	public LocalDate getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "User_Book [issueNumber=" + issueNumber + ", issuedDate=" + issuedDate + ", dueDate=" + dueDate
				+ ", returnDate=" + returnDate + ", user=" + user + ", book=" + book + "]";
	}

	public User_Book(LocalDate issuedDate, LocalDate dueDate, LocalDate returnDate, User user, Book book) {
		super();
		this.issuedDate = issuedDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.user = user;
		this.book = book;
	}
	
	
	

}
