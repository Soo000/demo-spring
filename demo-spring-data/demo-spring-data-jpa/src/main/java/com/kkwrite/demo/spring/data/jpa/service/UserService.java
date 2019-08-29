package com.kkwrite.demo.spring.data.jpa.service;

import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kkwrite.demo.spring.data.jpa.dao.UserRepository;
import com.kkwrite.demo.spring.data.jpa.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public List<User> save(List<User> users) {
		return userRepository.save(users);
	}
	
	/**
	 * 根据用户名分页查询
	 * @param criterias
	 * @return
	 */
	public Page<User> findAllPagingByUsername(String username, int page, int size) {
		// 查询条件
		Specification<User> specification = (root, query, cb) -> {
			Path path = root.get("username");
			Predicate predicate = cb.equal(path, username);					
			return predicate;
		};
		
		// 分页条件
		PageRequest pageRequest = new PageRequest(page - 1, size);
		// 执行查询
		return userRepository.findAll(specification, pageRequest);
	}
	
}
