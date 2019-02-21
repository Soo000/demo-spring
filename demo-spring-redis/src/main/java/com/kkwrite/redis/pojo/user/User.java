package com.kkwrite.redis.pojo.user;

import java.io.Serializable;

import com.kkwrite.redis.pojo.BasePojo;  

public class User extends BasePojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5162592606076781447L;
	
	private int id;
	private String name;
	private String sex;
	private int age;
	
	public User() {  
        super();  
    }  
      
    public User(Integer id, String name) {  
        super();  
        this.id = id;  
        this.name = name;  
    }  
  
    public User(String name, String sex, Integer age) {  
        super();  
        this.name = name;  
        this.sex = sex;  
        this.age = age;  
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
