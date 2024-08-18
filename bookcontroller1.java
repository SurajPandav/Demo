package com.api.book1.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book1.entities.Book;
import com.api.book1.service.BookService;


@RestController
public class bookcontroller1 {

	@Autowired
	private BookService bookservice;
	
/******************************************************************************/	
	//Read data
	
	//@RequestMapping(value="/books", method=RequestMethod.GET)   //use below annotation
/*	
    @GetMapping("/books")                      
	public List<Book> getBooks() {
		
          //Book b1=new Book();
          //		
          //b1.setId(11);
          //b1.setTitle("c programming");
          //b1.setAuthor("YZ");
          //return b1;
		
		return this.bookservice.getAllBooks();
		
	}*/
		
	//if you want to sent response status then below code
	
	@GetMapping("/books")                      
	public ResponseEntity<List<Book>> getBooks() {
		
		List<Book> list=this.bookservice.getAllBooks();
		
		if(list.size()<=0) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	/*
	 //to get single book 
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int idd) {
		
		return bookservice.getBookById(idd);
	}*/
	
	//if you want to sent response status then below code
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int idd) {
		
		Book book= bookservice.getBookById(idd);
		
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
/*************************************************************************************/	
	//Create

	/*
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {  //@RequestBody annotation converts json data into java obj
		
		Book b=this.bookservice.addBook(book);
		
		System.out.println(book);
		return b;
	}*/
	
	//if you want to sent response status then below code
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {  //@RequestBody annotation converts json data into java obj
		
		Book b=null;
		
		try {
		 b=this.bookservice.addBook(book);
		
		System.out.println(book);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
		}catch(Exception e) {
			e.printStackTrace();	
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() ;
		}
		
		
	}
/****************************************************************************************/
	//Delete
	
	/*
	@DeleteMapping("/books/{bookid}")
	public void deleteBook(@PathVariable("bookid") int bookid ) {
		this.bookservice.DeleteBookk(bookid);
	}*/
	
	//if you want to sent response status then below code
	
	@DeleteMapping("/books/{bookid}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookid") int bookid ) {
		try {
		this.bookservice.DeleteBookk(bookid);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
/*****************************************************************************************/
	//Update
	
	/*
	@PutMapping("/books/{bokid}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bokid") int bokid) {
		
		this.bookservice.updateBookk(book,bokid);
		return book;
	}*/
	
	//if you want to sent response status then below code
	
	@PutMapping("/books/{bokid}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bokid") int bokid) {
		
		try {
			this.bookservice.updateBookk(book,bokid);
			return ResponseEntity.ok().body(book);
		}catch(Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
		
	}
}
