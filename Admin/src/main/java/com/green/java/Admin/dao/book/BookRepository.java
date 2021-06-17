package com.green.java.Admin.dao.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.green.java.Admin.entity.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	@Query("SELECT book FROM Book book WHERE book.title = :title")
	public Book getBookByTitle(@Param("title") String title);
	
}
