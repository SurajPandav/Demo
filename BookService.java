package com.api.book1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book1.Dao.BookRepository;
import com.api.book1.entities.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	//get all books
	public List<Book> getAllBooks(){
		
		List<Book> list=(List<Book>) this.bookRepository.findAll();
		
		return list;
	}
	
	//get book by id
	public Book getBookById(int id) {
		
		Book boo=null;
		
		try {
			
		boo=this.bookRepository.findById(id);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return boo;
	}
	
	//add book
	public Book addBook(Book bk) {
		Book result=this.bookRepository.save(bk);
		
		return result;
	}
	
	//Delete book
	public void DeleteBookk(int bid) {
		
		this.bookRepository.deleteById(bid);
	}
	
	//update book
	public void updateBookk(Book boo,int bbid) {
		
		boo.setId(bbid);
		this.bookRepository.save(boo);
		
	}
}
