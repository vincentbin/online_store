package com.polyu.hm.service;

import com.polyu.hm.dao.CartRepository;
import com.polyu.hm.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    /**
     * 根据userId 获取购物车物品
     * @param userId
     * @return
     */
    public List<Cart> getCartItems(Integer userId) {
        return cartRepository.getCartById(userId);
    }

    /**
     * 减少库存
     * @param id
     */
    public void reduceItem(Integer id) {
        cartRepository.reduceItem(id);
    }

    /**
     * 增加库存
     * @param id
     */
    public void addItem(Integer id) {
        cartRepository.addItem(id);
    }

    /**
     * 插入新书
     * @param bookId
     */
    public void insertItem(Integer bookId, Integer userId) {
        cartRepository.insertItem(bookId, userId);
    }

    /**
     * 删除书
     * @param bookId
     */
    public void deleteItem(Integer bookId, Integer userId) {
        cartRepository.deleteItem(bookId, userId);
    }
}
