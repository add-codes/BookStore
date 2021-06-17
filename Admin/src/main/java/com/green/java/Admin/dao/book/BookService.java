package com.green.java.Admin.dao.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.java.Admin.entity.book.Book;

@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBook() {
		return (List<Book>) bookRepository.findAll();
	}
	
	

}
