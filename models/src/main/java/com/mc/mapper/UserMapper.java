package com.mc.mapper;


import com.mc.MyMapper;
import com.mc.entity.User;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
    void insertUser(User user);
}
