package com.demo.spring.tx.xml;

public interface BookShopDao {

	public int findBookPriceByIsbn(String isbn);
	
	public void updateBookStock(String isbn);
	
	public void updateUserBalance(String username, int price);
	
}
