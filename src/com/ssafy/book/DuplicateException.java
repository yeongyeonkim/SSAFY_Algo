package com.ssafy.book;

public class DuplicateException extends Exception{

	public DuplicateException() {
		this("DuplicateException");
	}

	public DuplicateException(String message) {
		super(message);
	}

}
