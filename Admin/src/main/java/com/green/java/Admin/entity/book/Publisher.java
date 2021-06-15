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

@Entity
@Table(name = "PUBLISHER")
public class Publisher {

	@Id
	@Column(name = "PUBLISHER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pubID;

	@Column(name = "PUBLISHER_NAME")
	private String pubName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "BOOK_DETAIL", 
				joinColumns = @JoinColumn(name = "PUBLISHER_ID"), 
				inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	private Set<Book> publisherBook = new HashSet<>();

	public Publisher() {
		super();
	}

	public Publisher(Integer pubID, String pubName) {
		super();
		this.pubID = pubID;
		this.pubName = pubName;
	}

	public Set<Book> getPublisherBook() {
		return publisherBook;
	}

	public void setPublisherBook(Set<Book> publisherBook) {
		this.publisherBook = publisherBook;
	}

	public Integer getPubID() {
		return pubID;
	}

	public void setPubID(Integer pubID) {
		this.pubID = pubID;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

}
