package com.mc.mapper;


import com.mc.MyMapper;
import com.mc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends MyMapper<User> {
    void foreachinsert(List<User> list);
    void deleteforecah(List<Integer> list);
}
