package com.example.demo.service.user;

import com.example.demo.entity.user.User;

public interface IUserService {

	public User loginUserByNamePass(User user);

	public int insertUser(User user);
	public int changePasswordByUserId(User user);
}
