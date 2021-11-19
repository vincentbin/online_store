package com.polyu.hm.vo;

import lombok.Data;

@Data
public class BookVo {
    Integer id;
    String bookName;
    String author;
    String publisher;
    Double price;
    Double priceOff;
    String description;
    String img;
}
