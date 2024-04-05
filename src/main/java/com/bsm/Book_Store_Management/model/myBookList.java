package com.bsm.Book_Store_Management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MY BOOKS")
public class myBookList {
	@Id
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "Author")
	private String author;
	
	@Column(name = "Price")
	private Double price;
	
	public myBookList() {
		// TODO Auto-generated constructor stub
	}

	public myBookList(Long id, String name, String author, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
