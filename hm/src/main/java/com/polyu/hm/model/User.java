package com.polyu.hm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@TableName(value = "user")
@Data
public class User {
    @TableId(value="id" , type = IdType.AUTO)
    Integer id;
    @TableField(value="username")
    String userName;
    @TableField(value="password")
    String passWord;
    Integer points;

    Integer role = 0;
}
