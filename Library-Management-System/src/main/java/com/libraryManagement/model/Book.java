package com.libraryManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer serialNumber;
	
	private String bookName;
	
	private String autherName;
	
	private Integer totalCopy;

	private Integer noOfCopyAvailable;

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAutherName() {
		return autherName;
	}

	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}

	public Integer getTotalCopy() {
		return totalCopy;
	}

	public void setTotalCopy(Integer totalCopy) {
		this.totalCopy = totalCopy;
	}

	public Integer getNoOfCopyAvailable() {
		return noOfCopyAvailable;
	}

	public void setNoOfCopyAvailable(Integer noOfCopyAvailable) {
		this.noOfCopyAvailable = noOfCopyAvailable;
	}

	public Book(Integer serialNumber, String bookName, String autherName, Integer totalCopy,
			Integer noOfCopyAvailable) {
		super();
		this.serialNumber = serialNumber;
		this.bookName = bookName;
		this.autherName = autherName;
		this.totalCopy = totalCopy;
		this.noOfCopyAvailable = noOfCopyAvailable;
	}
	
	
	

	
	
	

}
