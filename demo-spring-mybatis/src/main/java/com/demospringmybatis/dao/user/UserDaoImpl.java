package com.demospringmybatis.dao.user;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.demospringmybatis.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		// 操作数据库
		User user = sqlSession.selectOne("user.findUserById", 1);
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// 创建会话
		SqlSession sqlSession = this.getSqlSession();
		
		// 自增主键
		sqlSession.insert("user.insertUser", user);
		System.out.println("-- user.id = " + user.getId());
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// 创建会话
		SqlSession sqlSession = this.getSqlSession();
		
		// 操作数据库
		sqlSession.delete("user.deleteUserById", id);
	}
	
}
