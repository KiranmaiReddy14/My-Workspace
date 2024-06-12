package com.user.service;

import com.user.model.User;

public interface UserService {
	User findByUserId(String id);
}
