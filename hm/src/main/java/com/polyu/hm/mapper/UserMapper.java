package com.polyu.hm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.polyu.hm.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
