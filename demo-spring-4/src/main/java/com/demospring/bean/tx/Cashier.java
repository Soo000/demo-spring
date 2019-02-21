package com.demospring.bean.tx;

import java.util.List;

public interface Cashier {

	/**
	 * 一个人买多本书
	 * @param username
	 * @param isbns
	 */
	public void checkout(String username, List<String> isbns);
	
}
