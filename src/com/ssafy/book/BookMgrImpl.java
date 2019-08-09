package com.ssafy.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookMgrImpl implements IBookMgr {
	
	private List<Book> b;
	
	private BookMgrImpl() {
		b = new ArrayList<Book>();
		load();
	}
	private static BookMgrImpl instance;
	public static BookMgrImpl getInstance() {
		if(instance == null)
			instance = new BookMgrImpl();
		return instance;
	}
	
	
	public void add(Book b2) throws DuplicateException {
		try {
			search(b2.getIsbn());
			throw new DuplicateException(b2.getIsbn());
		} catch (NotFoundException e) {
			b.add(b2);
		}
	}
	public List<Book> search() {
		return b;
	}
	public Book search(String isbn) throws NotFoundException {
		for(Book s : b) {
			if(s.getIsbn().equals(isbn))
				return s;
		}
		throw new NotFoundException(isbn);
	}
	public void update(String isbn, int price) throws NotFoundException {
		Book s = search(isbn);
		s.setPrice(price);
	}
	public void delete(String isb) throws NotFoundException {
		Book s = search(isb);
		b.remove(s);
	}
	public void load() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat"));){
			Object obj = ois.readObject();
			if(obj != null)
				b = (List)obj;
		}catch(Exception e) {
			System.out.println("load 못했습니당");
		}
		
	}
	public void save() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"));){
			oos.writeObject(b);
			System.out.println("yo");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}