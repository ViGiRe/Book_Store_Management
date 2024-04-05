package com.bsm.Book_Store_Management.Iservice;

import java.util.List;

import com.bsm.Book_Store_Management.model.Book;

public interface BookServiceInterface {
	
	void save(Book book);
	
	List<Book> getAllBooks();
	Book getBookById(Long id);
	public void deleteBookById(Long id);
}
