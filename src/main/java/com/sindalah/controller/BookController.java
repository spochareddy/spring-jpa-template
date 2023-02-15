package com.sindalah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sindalah.model.Book;
import com.sindalah.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(path = "books")
	public List<Book> findAll() {
		List<Book> list = bookService.findAll();
		log.info("Book list Size ::" + list.size());

		return list;
	}

	@GetMapping(path = { "books/{id}" })
	public ResponseEntity<Book> findById(@PathVariable long id) {
		log.info("Inside findById ::" + id);
		return bookService.findById(id);
	}
	
	@PostMapping(path = { "books" })
	public Book publishBook(@RequestBody Book book) {
		
		log.info("publishBook object ::" + book.toString());
		return bookService.publishBook(book);
	}
}
