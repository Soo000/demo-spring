package com.demo.spring.tx;

public class BookStockException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7975042720155590197L;

	public BookStockException(String message) {
		super(message);
	}
	
}
