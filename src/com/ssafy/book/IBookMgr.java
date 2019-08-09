package com.ssafy.book;

import java.util.List;

public interface IBookMgr {
	public void add(Book b) throws DuplicateException;
	
	public List<Book> search();
	
	public Book search(String isbn) throws NotFoundException;
	
	public void update(String isbn, int price) throws NotFoundException;
	
	public void delete(String isb) throws NotFoundException;
	
	public void save();
	
	public void load();
}
