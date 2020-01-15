package com.demo.spring.tx;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = "select price from book where isbn = ?";
		
		int price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return price;
	}

	@Override
	public void updateBookStock(String isbn) {
		// 检查库存
		String checkStock = "select stock from book_stock where isbn = ?";
		int stock = jdbcTemplate.queryForObject(checkStock, Integer.class, isbn);
		if (stock <= 0) {
			throw new BookStockException("已经没有库存了！");
		}
		
		String sql = "update book_stock set stock = stock - 1 where isbn = ?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateUserBalance(String username, int price) {
		String checkBalance = "select balance from account where username = ?";
		int balance = jdbcTemplate.queryForObject(checkBalance, Integer.class, username);
		if (balance < price) {
			throw new UserAccountException("余额不足！");
		}
		
		String sql = "update account set balance = balance - ? where username = ?";
		System.out.println("price=" + price);
		jdbcTemplate.update(sql, price, username);
	}

}
