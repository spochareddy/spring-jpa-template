package com.sindalah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sindalah.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	public Book findById(@Param("id") String id);

	public List<Book> findByAuthor(@Param("author") String author);

}
