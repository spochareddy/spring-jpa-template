package com.sindalah.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sindalah.model.Book;

public interface BookService {

	public List<Book> findAll();

	public ResponseEntity<Book> findById(long id);
	
	public Book publishBook(final Book book);
}
