package com.bsm.Book_Store_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bsm.Book_Store_Management.Iservice.MyBookServiceInterface;
@Controller
public class MyBookListController {
	
	@Autowired
	private MyBookServiceInterface myBookServiceInterface;
	
	@RequestMapping(path= "/delete/{id}",method = RequestMethod.GET)
	public String deleteBookById(@PathVariable("id") Long id) {
		 myBookServiceInterface.deleteBookById(id);
		 
		 return "redirect:/my_books";
	}

}
