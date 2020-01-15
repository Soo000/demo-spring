package com.demo.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;

	/**
	 * 1.事物的传播行为用progation
	 * 2.事物的隔离级别用isolation, 常用的为READ_COMMITTTED
	 * 3.默认情况下Spring声明式事物对所有异常进行回滚，也可以通过对于属性设置。 
	 * 		noRollbackFor={UserAccountException.class}，对UserAccountException.class不回滚
	 * 4.readOnly 指定事物是否只读 . 只读事物可以帮助数据库引擎加快读取速度。
	 * 5.timeout=秒,事物占用连接时间多久后进行强制回滚
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED,
			readOnly=false,
			timeout=3)
	@Override
	public void purchase(String username, String isbn) {
		// 获取单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		// 更新库存
		bookShopDao.updateBookStock(isbn);
		
		// 更新余额
		bookShopDao.updateUserBalance(username, price);
	}

}
