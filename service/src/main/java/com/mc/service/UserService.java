package com.mc.service;

import com.mc.entity.User;

import java.util.List;

public interface UserService extends BaseService<User>{
    void insertUser(User user);
}
