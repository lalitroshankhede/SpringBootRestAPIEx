package com.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Book>> getBooks()
	{
		 
		List<Book> bookList= bookService.getAllBooks();
	    
		if (bookList.size()<=0) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		 
		return ResponseEntity.of(Optional.of(bookList));
		
	}
	
	

	// getting single book 
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getSingleBook(@PathVariable("id") int id)
	{
		
	 Book singleBook= bookService.getBookById(id);
		
	 if (singleBook==null) {
		
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 
	}
	 
	 return ResponseEntity.of(Optional.of(singleBook));
	 
	}
	
	
	 
	// creating or adding new book  
	
	@PostMapping("/books")
	public  ResponseEntity<Book> addBook(@RequestBody Book addBook)
	{
		
		Book b=null;
		try {
			
			 b=bookService.addBook(addBook);
		  System.out.println(addBook);
		  return ResponseEntity.of(Optional.of(b));
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		 
		
	 
		
	}

	// delete book 
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId)
	{
        
		 try {
			
			 bookService.deleteBook(bookId);
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			 
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		 
	}
	
	
	// update book 
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book>  updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		
		 try {
			
			 bookService.updateBook(book,bookId);
			 return ResponseEntity.ok().body(book);
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		 
	}
	
	
}
