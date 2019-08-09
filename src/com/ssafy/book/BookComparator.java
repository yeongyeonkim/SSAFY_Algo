package com.ssafy.book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		
		int r = o1.getTitle().compareTo(o2.getTitle());
		if(r == 0) {
			r = Integer.compare(o1.getPrice(), o2.getPrice());
			if(r == 0) {
				r = Integer.compare(o1.getQuantity(), o2.getQuantity());
			}
		}
		return r;
	}
	
}
