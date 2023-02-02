package com.libraryManagement.model;

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
	
	private Date issuedDate;
	
	private Date dueDate;
	
	private Date returnDate;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Book book;
	

}
