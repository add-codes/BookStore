package com.green.java.Admin.entity.book;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.green.java.Admin.entity.staff.Staff;

@Entity
@Table(name = "AUTHOR")
public class Author {

	@Id
	@Column(name = "AUTHOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authorID;

	@Column(name = "AUTHOR_NAME")
	private String authorName;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "BOOK_DETAIL",
				joinColumns = @JoinColumn(name = "AUTHOR_ID"),
				inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	private Set<Book> authorBook = new HashSet<>();

	public Author() {
		super();
	}

	public Author(Integer authorID, String authorName) {
		super();
		this.authorID = authorID;
		this.authorName = authorName;
	}

	public Set<Book> getAuthorBook() {
		return authorBook;
	}

	public void setAuthorBook(Set<Book> authorBook) {
		this.authorBook = authorBook;
	}

	public Integer getAuthorID() {
		return authorID;
	}

	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
