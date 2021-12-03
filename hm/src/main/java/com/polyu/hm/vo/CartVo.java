package com.polyu.hm.vo;

import lombok.Data;

@Data
public class CartVo {
    Integer id;
    Integer userId;
    Integer bookId;
    Integer sum;
    String bookName;
    Double price;
}
