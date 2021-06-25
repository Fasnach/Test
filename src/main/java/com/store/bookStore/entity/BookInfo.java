package com.store.bookStore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.store.bookStore.model.BookClassification;

@Entity

public class BookInfo {

	@Id
	@GeneratedValue
	/**
	 * id
	 */
	private int id;
	/**
	 * name of the book
	 */
	private String name;
	/**
	 * category of book
	 */
	private String category;
	/**
	 * Book description
	 */
	private String description;
	/**
	 * Author name
	 */
	private String author;
	/**
	 * price of the book
	 */
	private double price;
	/**
	 * ISBN
	 */
	private String isbn;
	/**
	 * Book classification
	 */
	private BookClassification classification;

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 
	 * @return
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * 
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * 
	 * @return
	 */
	public BookClassification getClassification() {
		return classification;
	}

	/**
	 * 
	 * @param classification
	 */
	public void setClassification(BookClassification classification) {
		this.classification = classification;
	}

}
