package com.ssafy.book;

public class NotFoundException extends Exception{
	public NotFoundException() {
		this("NotFoundException");
	}
	public NotFoundException(String msg) {
		super(msg);
	}
}
