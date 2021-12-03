package com.polyu.hm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@TableName(value = "t_order")
@Data
public class Cart {
    @TableId(value="id" , type = IdType.AUTO)
    Integer id;
    @TableField(value="userid")
    Integer userId;
    @TableField(value="bookid")
    Integer bookId;
    Integer sum;
}
