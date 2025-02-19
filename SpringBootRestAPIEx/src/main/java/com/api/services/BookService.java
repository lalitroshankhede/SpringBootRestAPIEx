package com.api.services;

import com.api.*;
import com.api.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


@Component
public class BookService  {

	private static List<Book> list=new ArrayList<>();
	static
	{
		
		list.add(new Book(11,"Avengers Endgame","Martin Cartage"));
		list.add(new Book(12,"Venom the last dance","Joe Don"));
		list.add(new Book(13,"Captain America","Alexandra Reo"));
        
	}
	
	//get all books
	
	public List<Book> getAllBooks()
	{
	    return list;
	}
	
	
	//get single book
	
	public Book getBookById(int id)
	{
		Book book=new Book(); 
		
		for (Book b : list) {
	        if (b.getId() == id) {
	            book = b;
	            break;
	        }
	    }
	  
	 return book;
	
		
	}
	
	
	// adding book
	
	public Book addBook(Book b)
	{
		list.add(b);
		return b;
	}


	// delete book
	
	public void deleteBook(int bid) {
	 
  		list= list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
  		
	}

	
	// update book

	public void updateBook(Book book, int bookId) {
		// TODO Auto-generated method stub
		
	list=list.stream().map(b->{
			
			if (b.getId()==bookId) {
				
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			 	 
			return b;
		}).collect(Collectors.toList());
		
		
	}


 
	
	
	
	
}
