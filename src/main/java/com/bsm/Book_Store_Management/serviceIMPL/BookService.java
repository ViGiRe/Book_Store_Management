package com.bsm.Book_Store_Management.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsm.Book_Store_Management.Iservice.BookServiceInterface;
import com.bsm.Book_Store_Management.model.Book;
import com.bsm.Book_Store_Management.repository.BookRepository;

@Service
public class BookService implements BookServiceInterface{
	@Autowired
	private BookRepository bookRepository;

	
	@Override
	public void save(Book book) {
		
		 bookRepository.save(book);
	}


	@Override
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}

	
	@Override
	public Book getBookById(Long id) {
		
		return bookRepository.findById(id).get();
	}


	@Override
	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
		
	}

}
