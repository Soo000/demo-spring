package com.demo.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.spring.tx.entity.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int save(User user) {
		int result = 0;
		
		String sql = "insert into ics_user(username, company_id, password, visitor_num, e_mail, is_deleted, gmt_create, gmt_modified) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		result = jdbcTemplate.update(sql, 
				user.getUsername(), 
				user.getCompanyId(),
				user.getPassword(),
				user.getVisitorNum(),
				user.getEmail(),
				user.getDeleted(),
				user.getGmtCreate(),
				user.getGmtModified());
		
		return result;
	}
	
}
