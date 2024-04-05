package com.bsm.Book_Store_Management.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsm.Book_Store_Management.Iservice.MyBookServiceInterface;
import com.bsm.Book_Store_Management.model.myBookList;
import com.bsm.Book_Store_Management.repository.MyBooksRepository;

@Service
public class MyBookService implements MyBookServiceInterface{
	
	@Autowired
	private MyBooksRepository myBooksRepository;

	public void saveMyBookList(myBookList myBookList) {
		myBooksRepository.save(myBookList);
	}
	
	public List<myBookList> getAllMyBooks() {
		return myBooksRepository.findAll();
	}

	@Override
	public void deleteBookById(Long id) {
		myBooksRepository.deleteById(id);
		
	}
}
