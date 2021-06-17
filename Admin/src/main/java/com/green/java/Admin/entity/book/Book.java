package com.green.java.Admin.entity.book;

import java.util.Date;
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
@Table(name = "BOOK")
public class Book {

	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookID;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "EDITION")
	private Integer edition;
	
	@Column(name = "PUBLISHER")
	private String publisher;

	@Column(name = "PUBLICATION_DATE")
	private Date publicationDate;

	@Column(name = "PRICE")
	private double price;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "AUTHOR_BOOK",
				joinColumns = @JoinColumn(name = "BOOK_ID"),
				inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
	private Set<Author> bookAuthor = new HashSet<Author>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "CATEGORY_BOOK",
				joinColumns = @JoinColumn(name = "BOOK_ID"),
				inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
	private Set<Category> bookCategory = new HashSet<Category>();

	public Book() {
		super();
	}

	public Book(Integer bookID, String title, Integer edition, String publisher, Date publicationDate, double price) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.edition = edition;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
		this.price = price;
	}

	public Set<Author> getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(Set<Author> bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Set<Category> getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(Set<Category> bookCategory) {
		this.bookCategory = bookCategory;
	}

	public Integer getBookID() {
		return bookID;
	}

	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
