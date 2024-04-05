package com.bsm.Book_Store_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsm.Book_Store_Management.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
