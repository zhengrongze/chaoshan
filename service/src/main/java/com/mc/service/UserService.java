package com.mc.service;

import com.mc.entity.User;

import java.util.List;

public interface UserService {
    void add();
    void inse(List<User> list);
    void delete(List<Integer> list);
    List<User> oneToOne();
}
