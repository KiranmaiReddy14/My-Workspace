package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repo.UserRepository;

@Service
public abstract class UserService implements UserRepository {

	@Autowired
	UserRepository repo;

	public User findByUserId(String id) {
		return repo.findById(id).get();
	}
}
