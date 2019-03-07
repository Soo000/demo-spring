package com.demospring.bean.tx;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBookShop {

	private ApplicationContext ctx;
	private BookShopDao bookShopDao;
	private BookShopService bookShopService;
	private Cashier cashier;
	
	{
		ctx = new ClassPathXmlApplicationContext("com/demospring/bean/tx/beans-jdbc.xml");
		bookShopDao = (BookShopDao) ctx.getBean("bookShopDao");
		bookShopService = (BookShopService) ctx.getBean(BookShopService.class);
		cashier = (Cashier) ctx.getBean(Cashier.class);
	}
	
	@Test
	public void testFindBookPriceByIsbn() {
		String isbn = "1001";
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		System.out.println("price = " + price);
	}

	@Test
	public void testUpdateBookStock() {
		bookShopDao.updateBookStock("1001");
	}
	
	@Test
	public void testUpdateUserBalance() {
		bookShopDao.updateUserBalance("AA", 200);
	}
	
	@Test
	public void testPurchase() {
		String username = "AA";
		String isbn = "1001";
		bookShopService.purchase(username, isbn);
	}
	
	@Test
	public void testCheckout() {
		String username = "AA";
		cashier.checkout(username, Arrays.asList("1001", "1002"));
	}

}
