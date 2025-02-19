package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.entities.Book;
import com.api.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	// getting all books 
	
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		 
		return bookService.getAllBooks();
	}
	
	

	// getting single book 
	
	@GetMapping("/books/{id}")
	public Book getSingleBook(@PathVariable("id") int id)
	{
		
		return bookService.getBookById(id);
		
	}
	
	
	 
	// creating or adding new book  
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book obj)
	{
		
		Book b=bookService.addBook(obj);
		
		return b;
	}
	
	
	
	// delete book 
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId)
	{
        
		 bookService.deleteBook(bookId);
		 
	}
	
	
	// update book 
	
	@PutMapping("/books/{bookId}")
	public Book  updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		bookService.updateBook(book,bookId);
		return book;
		
	}
	
	
}
