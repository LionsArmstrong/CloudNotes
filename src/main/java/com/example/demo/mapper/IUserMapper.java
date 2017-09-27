package com.example.demo.mapper;

import com.example.demo.entity.user.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/7/26.
 */
@Repository(value="iUserMapper")
public interface IUserMapper {
    public User loginUserByNamePass(User user);
    public int changePasswordByUserId(User user);

    public int insertUser(User user);
}
