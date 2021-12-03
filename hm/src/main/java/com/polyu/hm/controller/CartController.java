package com.polyu.hm.controller;

import com.polyu.hm.model.Cart;
import com.polyu.hm.model.User;
import com.polyu.hm.result.Result;
import com.polyu.hm.service.CartService;
import com.polyu.hm.service.UserService;
import com.polyu.hm.vo.CartOperationReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "/cart")
@RestController
public class CartController {

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;

    @RequestMapping(value = "/items.json")
    public Result<List<Cart>> getCartItems(HttpServletRequest request) {
        User currentUser = userService.getCurrentUser(request);
        if (currentUser == null) {
            Result<List<Cart>> error = Result.error("need login.");
            error.setCode(404);
            return error;
        }
        List<Cart> cartItems = cartService.getCartItems(currentUser.getId());
        return Result.success(cartItems);
    }

    @RequestMapping(value = "/reduce_item.do")
    public Result<Boolean> reduceItem(HttpServletRequest request, CartOperationReq req) {
        User currentUser = userService.getCurrentUser(request);
        if (currentUser == null) {
            Result<Boolean> error = Result.error("need login.");
            error.setCode(404);
            return error;
        }
        cartService.reduceItem(req.getBookId());
        return Result.success(true);
    }

    @RequestMapping(value = "/add_item.do")
    public Result<Boolean> addItem(HttpServletRequest request, CartOperationReq req) {
        User currentUser = userService.getCurrentUser(request);
        if (currentUser == null) {
            Result<Boolean> error = Result.error("need login.");
            error.setCode(404);
            return error;
        }
        cartService.addItem(req.getBookId());
        return Result.success(true);
    }

    @RequestMapping(value = "/insert_item.do")
    public Result<Boolean> insertItem(HttpServletRequest request, CartOperationReq req) {
        User currentUser = userService.getCurrentUser(request);
        if (currentUser == null) {
            Result<Boolean> error = Result.error("need login.");
            error.setCode(404);
            return error;
        }
        cartService.insertItem(req.getBookId(), currentUser.getId());
        return Result.success(true);
    }

    @RequestMapping(value = "/delete_item.do")
    public Result<Boolean> deleteItem(HttpServletRequest request, CartOperationReq req) {
        User currentUser = userService.getCurrentUser(request);
        if (currentUser == null) {
            return Result.error("need login.");
        }
        cartService.insertItem(req.getBookId(), currentUser.getId());
        return Result.success(true);
    }
}
