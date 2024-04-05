package com.bsm.Book_Store_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bsm.Book_Store_Management.Iservice.BookServiceInterface;
import com.bsm.Book_Store_Management.Iservice.MyBookServiceInterface;
import com.bsm.Book_Store_Management.model.Book;
import com.bsm.Book_Store_Management.model.myBookList;


@Controller
public class BookController {
	@Autowired
	private BookServiceInterface bookServiceInterface;
	
	@Autowired
	private MyBookServiceInterface myBookServiceInterface;
	
	@RequestMapping("/home")
	public String HomePage() {
		return "home";
	}

	@RequestMapping("/register")
	public String Registration() {
		return "register";
	}

	@RequestMapping("/available_books")
	public ModelAndView AvailableBooks() {
		List<Book> bookList = bookServiceInterface.getAllBooks();
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("available_books");
//		modelAndView.addObject("book", bookList);
		return new ModelAndView("available_books", "book", bookList);
	}

	@RequestMapping(path="/my_books",method = RequestMethod.GET)
	public String MyBooks(Model model) {
		List<myBookList> myBookList = myBookServiceInterface.getAllMyBooks();
		model.addAttribute("book", myBookList);
		return "my_books";
	}
	
	@RequestMapping(path="/save",method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		bookServiceInterface.save(book);
		return "redirect:/available_books";
		
	}
	
//	@RequestMapping("/available_books")
//	public ModelAndView getAllBooks() {
//		List<Book> bookList = bookServiceInterface.getAllBooks();
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("available_books");
//		modelAndView.addObject("book", bookList);
//		return new ModelAndView("available_books", "book", bookList);
//	}
	
	@GetMapping("/myList/{id}")
	public String getMyList(@PathVariable Long id) {
		Book b = bookServiceInterface.getBookById(id);
		myBookList myBookList = new myBookList(b.getId(),b.getName(),b.getAuthor(), b.getPrice());
		myBookServiceInterface.saveMyBookList(myBookList);
		return "redirect:/my_books";		
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable Long id,Model model) {
		
		Book b = bookServiceInterface.getBookById(id);
		model.addAttribute("book", b);
		return "edit";
		
	}
	
	@RequestMapping(path = "/deleteBook/{id}",method = RequestMethod.GET)
	public String deleteBook(@PathVariable Long id) {
		bookServiceInterface.deleteBookById(id);
		return "redirect:/available_books";
	}
}
