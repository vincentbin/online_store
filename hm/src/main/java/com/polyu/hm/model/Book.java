package com.polyu.hm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@TableName(value = "book")
@Data
public class Book {
    @TableId(value="id" , type = IdType.AUTO)
    Integer id;
    @TableField(value="typeId")
    Integer typeId;
    @TableField(value="bookname")
    String bookName;
    String author;
    String publisher;
    Date publishTime;
    Double price;
    @TableField(value="priceoff")
    Double priceOff;
    String description;
    String catalog;
    String img;
}
