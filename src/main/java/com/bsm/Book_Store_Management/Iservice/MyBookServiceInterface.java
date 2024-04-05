package com.bsm.Book_Store_Management.Iservice;

import java.util.List;

import com.bsm.Book_Store_Management.model.myBookList;

public interface MyBookServiceInterface {
	void saveMyBookList(myBookList myBookList);
	List<myBookList> getAllMyBooks();
	void deleteBookById(Long id);
}
