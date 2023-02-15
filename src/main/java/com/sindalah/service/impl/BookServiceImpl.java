package com.sindalah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sindalah.model.Book;
import com.sindalah.repository.BookRepository;
import com.sindalah.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository repository;

	@Override
	public List<Book> findAll() {
		return repository.findAll();

	}

	@Override
	public ResponseEntity<Book> findById(long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@Override
	public Book publishBook(Book book) {
		return repository.save(book);
	}

}
