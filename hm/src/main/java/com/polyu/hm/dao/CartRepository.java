package com.polyu.hm.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.polyu.hm.mapper.CartMapper;
import com.polyu.hm.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {

    @Autowired
    CartMapper cartMapper;

    /**
     * 根据用户id 获取所有购物车物品
     * @param userId
     * @return
     */
    public List<Cart> getCartById(Integer userId) {
        QueryWrapper<Cart> wrapper = new QueryWrapper<>();
        wrapper.and(w -> w.eq("userid", userId));
        return cartMapper.selectList(wrapper);
    }

    /**
     * 减少库存
     * @param id
     */
    public void reduceItem(Integer id) {
        Cart cart = cartMapper.selectById(id);
        cart.setSum(cart.getSum() - 1);
        cartMapper.updateById(cart);
    }

    /**
     * 增加库存
     * @param id
     */
    public void addItem(Integer id) {
        Cart cart = cartMapper.selectById(id);
        cart.setSum(cart.getSum() + 1);
        cartMapper.updateById(cart);
    }

    /**
     * 插入新条目
     * @param bookId
     * @param userId
     */
    public void insertItem(Integer bookId, Integer userId) {
        QueryWrapper<Cart> wrapper = new QueryWrapper<>();
        wrapper.and(w -> w.eq("bookid", bookId))
                .and(w -> w.eq("userid", userId));
        Cart cartItem = cartMapper.selectOne(wrapper);
        if (cartItem == null) {
            Cart cart = new Cart();
            cart.setBookId(bookId);
            cart.setUserId(userId);
            cart.setSum(1);
            cartMapper.insert(cart);
            return;
        }
        addItem(cartItem.getId());
    }

    /**
     * 删除条目
     * @param bookId
     * @param userId
     */
    public void deleteItem(Integer bookId, Integer userId) {
        QueryWrapper<Cart> wrapper = new QueryWrapper<>();
        wrapper.and(w -> w.eq("bookid", bookId))
                .and(w -> w.eq("userid", userId));
        cartMapper.delete(wrapper);
    }
}
