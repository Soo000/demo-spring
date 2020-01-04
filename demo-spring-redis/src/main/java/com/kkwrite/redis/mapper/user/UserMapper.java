package com.kkwrite.redis.mapper.user;

import java.util.List;

import com.kkwrite.redis.pojo.user.User;

/** 
 * UserMapper接口 
 */  
public interface UserMapper {  
      
    /** 
     * 保存用户 
     * @param user 
     */  
    void saveUser(User user);  
      
    /** 
     * 获取所有用户列表 
     * @return 
     */  
    List<User> getAllUser();  
      
    /** 
     * 根据id查询用户信息 
     * @param id 
     * @return 
     */  
    User getUserById(Integer id);  
      
    /** 
     * 更新用户的名称 
     * @param user 
     */  
    void renameUser(User user);  
      
    /** 
     * 根据id删除指定的用户 
     * @param id 
     */  
    void deleteUserById(Integer id);  
}
