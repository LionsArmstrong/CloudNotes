package com.example.demo.service.user.impl;

import com.example.demo.entity.user.User;
import com.example.demo.mapper.IUserMapper;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value="iUserService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserMapper iUserMapper;

	@Override
	public User loginUserByNamePass(User user) {
		return iUserMapper.loginUserByNamePass(user);
	}

	@Override
	public int insertUser(User user) {
		return iUserMapper.insertUser(user);
	}

	@Override
	public int changePasswordByUserId(User user) {
		return iUserMapper.changePasswordByUserId(user);
	}
}
