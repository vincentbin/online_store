package com.polyu.hm.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.polyu.hm.mapper.UserMapper;
import com.polyu.hm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    public User getById(String mobileNum) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.and(w -> w.eq("username", mobileNum));
        return userMapper.selectOne(wrapper);
    }

    public boolean insert(User user) {
        int insert = userMapper.insert(user);
        return insert == 1;
    }
}
