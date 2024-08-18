package com.api.book1.Dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book1.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	
	public Book findById(int id); 
		
	
}
