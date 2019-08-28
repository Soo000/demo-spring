package com.kkwrite.demo.spring.data.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import com.kkwrite.demo.spring.data.jpa.entity.Customer;

@RepositoryDefinition(domainClass = Customer.class, idClass = Integer.class)
public interface CustomerResopistory {

	Customer findById(Integer id);
	
	List<Customer> getByLastNameStartingWith(String lastName);
	
	List<Customer> getByLastNameContaining(String words);
	
	List<Customer> getByIdIn(List<Integer> ids);
	
	/**
	 * 级联查询
	 * @param addressId
	 * @return
	 */
	Customer findByAddressesId(Integer addressId);
	
	/**
	 * 无参的 Query 查询
	 * @return
	 */
	@Query("SELECT c FROM Customer c WHERE c.id = (SELECT max(c2.id) FROM Customer c2)")
	Customer getMaxIdCustomer();
	
	/**
	 * 带参数的 Query 查询（占位符方式）
	 * @param lastName
	 * @param password
	 * @param email
	 * @return
	 */
	@Query("select c from Customer c where c.lastName = ?1 and c.password = ?2 and c.email = ?3")
	List<Customer> getByParams(String lastName, String password, String email);
	
	/**
	 * 带参数的 Query 查询（命名方式）
	 * @param lastName
	 * @param password
	 * @param email
	 * @return
	 */
	@Query("select c from Customer c where c.lastName = :lastName and c.password = :password and c.email = :email")
	List<Customer> getByCustomParams(@Param("lastName") String lastName, @Param("password") String password, @Param("email") String email);
	
	/**
	 * like查询
	 * @param lastName
	 * @param email
	 * @return
	 */
	@Query("select c from Customer c where c.lastName like %?1% or c.email like %?2%")
	List<Customer> getByLikeParams(String lastName, String email);
	
	@Modifying
	@Query("update Customer c set c.lastName = :lastName where c.id = :id")
	int updateLastName(@Param("lastName") String lastName, @Param("id") Integer id);
	
}
