package com.ssafy.book;

import java.io.Serializable;

public class Book implements Serializable, Comparable<Book>{
	private String isbn;
	private String title;
	private int price;
	private int quantity;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// 생성자 오버로딩은 필요한만큼만.
	public Book() {
		this(null, null, 0, 0);
	}

	// //
	public Book(String isbn, String title, int price) {
		this(isbn, title, price, 0);
	}

	// 여긴 필수
	public Book(String isbn, String title, int price, int quantity) {
		setIsbn(isbn);
		setPrice(price);
		setQuantity(quantity);
		setTitle(title);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getIsbn()).append("\t")
		.append(getTitle()).append("\t")
		.append(getPrice()).append("\t")
		.append(getQuantity()).append("\t")
		;
		return sb.toString();		
	}

	public int compareTo(Book o) {
//		return this.isbn.compareTo(o.getIsbn()); // 오름차순 사전순 string
//		return o.getIsbn().compareTo(this.isbn); // 내림차순
		return Integer.compare(this.price, o.getPrice()); // 오름차순. int
	}
}
