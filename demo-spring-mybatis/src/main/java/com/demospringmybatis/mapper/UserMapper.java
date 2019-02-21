package com.demospringmybatis.mapper;

import java.util.List;

import com.demospringmybatis.po.User;
import com.demospringmybatis.po.UserCustom;
import com.demospringmybatis.po.UserQueryVo;

public interface UserMapper {

	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
	
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	public User findUserByIdResultMap(int id) throws Exception;
	
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public void deleteUserById(int id) throws Exception;
	
}
