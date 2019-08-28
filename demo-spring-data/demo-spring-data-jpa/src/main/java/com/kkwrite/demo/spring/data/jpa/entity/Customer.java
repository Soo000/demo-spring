package com.kkwrite.demo.spring.data.jpa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 客户
 */
@Entity
@Table(name = "sys_customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="last_name", length = 50)
	private String lastName;
	
	@Column(length = 128, nullable = false)
	private String password;
	
	private Integer age;
	@Column(length = 30)
	
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@Column(name = "is_deleted", nullable = false)
	private Integer isDeleted;
	
	@Column(name = "gmt_create")
	private Date gmtCreate;
	
	@Column(name = "gmt_modified")
	private Date gmtModified;
	
	/**
	 * mappedBy = "customer" 设置本端不维护关联关系，关联关系由 mappedBy 的值来指定
	 */
	@OneToOne(mappedBy = "customer")
	private CustomerDetail customerDetail;
	
	/**
	 * 账户
	 * 一个客户有多个账户；一个账户只对应一个客户
	 */
	@OneToMany
	@JoinColumn(name = "customer_id")
	private Set<Account> accounts = new HashSet<>();
	
	@OneToMany(mappedBy = "customer")
	private Set<Order> orders = new HashSet<>();

	/**
	 * 
	 */
	public Customer() {
	}
	
	/**
	 * 
	 * @param lastName
	 * @param password
	 */
	public Customer(String lastName, String password) {
		this.lastName = lastName;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}
	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", lastName=" + lastName + ", password=" + password + ", age=" + age + ", email="
				+ email + ", birthdate=" + birthdate + ", isDelete=" + isDeleted + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + "]";
	}
	
}
