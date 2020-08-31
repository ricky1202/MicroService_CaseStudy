package com.subscription.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="book")
@ToString()
public class Book {

	@Autowired
	ConversionService conversionService;
	
	public Book() {
		super();
		this.bookId = "";
		this.book_Name = "";
		this.author = "";
		this.available_copies = 0;
		this.total_copies = 0;
		// TODO Auto-generated constructor stub
	}

	public Book(String bookId, String book_Name, String author, int available_copies, int total_copies) {
		super();
		this.bookId = bookId;
		this.book_Name = book_Name;
		this.author = author;
		this.available_copies = available_copies;
		this.total_copies = total_copies;
	}

	@Id
	private String bookId;
	private String book_Name;
	private String author;
	private int available_copies;
	private int total_copies;

	
	public void setId(String bookId) {
		this.bookId = bookId;
	}

	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setAvailable_copies(int available_copies) {
		this.available_copies = available_copies;
	}

	public void setTotal_copies(int total_copies) {
		this.total_copies = total_copies;
	}


	public String getId() {
		return bookId;
	}
	
	public String getBook_Name() {
		return book_Name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getAvailable_copies() {
		return available_copies;
	}
	
	public int getTotal_copies() {
		return total_copies;
	}
	
	public String getBookName() {
		return book_Name;
	}
}
