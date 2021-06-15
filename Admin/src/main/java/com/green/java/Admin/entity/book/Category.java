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
@Table(name = "CATEGORY")
public class Category {

	@Id
	@Column(name = "CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cateID;

	@Column(name = "CATEGORY_NAME")
	private String cateName;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "BOOK_DETAIL",
				joinColumns = @JoinColumn(name = "CATEGORY_ID"),
				inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	private Set<Book> categoryBook = new HashSet<>();

	public Category() {
		super();
	}

	public Category(Integer cateID, String cateName) {
		super();
		this.cateID = cateID;
		this.cateName = cateName;
	}

	public Set<Book> getCategoryBook() {
		return categoryBook;
	}

	public void setCategoryBook(Set<Book> categoryBook) {
		this.categoryBook = categoryBook;
	}

	public Integer getCateID() {
		return cateID;
	}

	public void setCateID(Integer cateID) {
		this.cateID = cateID;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

}
