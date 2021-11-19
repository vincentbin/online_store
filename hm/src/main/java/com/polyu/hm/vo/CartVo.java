package com.polyu.hm.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CartVo {
    List<BookVo> books = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
}
