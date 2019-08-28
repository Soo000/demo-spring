package com.kkwrite.demo.spring.data.jpa.entity;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Cacheable(true)
@Entity
@Table(name = "sys_customer_detail")
public class CustomerDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 12)
	private String qq;
	
	@Column(length = 12)
	private String weixin;
	
	@Column(name = "is_deleted", nullable = false)
	private Integer isDeleted;
	
	@Column(name = "gmt_create")
	private Date gmtCreate;
	
	@Column(name = "gmt_modified")
	private Date gmtModified;
	
	@OneToOne
	@JoinColumn(name = "customer_id", unique = true)
	private Customer customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerDetail [id=" + id + ", qq=" + qq + ", weixin=" + weixin + ", isDeleted=" + isDeleted
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", customer=" + customer + "]";
	}
	
}
