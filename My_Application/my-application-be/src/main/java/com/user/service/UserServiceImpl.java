package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repo.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
	 private final UserRepository userRepository;

	    @Autowired
	    public UserServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	@Override
	public User findByUserId(String id) {
		return userRepository.findByUserId(id);
	}

}
