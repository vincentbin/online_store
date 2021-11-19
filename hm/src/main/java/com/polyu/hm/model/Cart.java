package com.polyu.hm.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@TableName(value = "t_order")
@Data
public class Cart {
    Integer id;
    @TableField(value="userid")
    Integer userId;
    @TableField(value="bookid")
    Integer bookId;
    Integer sum;
}
