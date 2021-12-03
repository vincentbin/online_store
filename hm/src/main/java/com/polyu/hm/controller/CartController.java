package com.polyu.hm.controller;

import com.polyu.hm.model.Book;
import com.polyu.hm.model.Cart;
import com.polyu.hm.model.User;
import com.polyu.hm.result.Result;
import com.polyu.hm.service.BookService;
import com.polyu.hm.service.CartService;
import com.polyu.hm.service.UserService;
import com.polyu.hm.vo.CartOperationReq;
import com.polyu.hm.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/cart")
@RestController
public class CartController {

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/items.json")
    public Result<List<CartVo>> getCartItems(HttpServletRequest request) {
        User currentUser = userService.getCurrentUser(request);
        if (currentUser == null) {
            Result<List<CartVo>> error = Result.error("need login.");
            error.setCode(404);
            return error;
        }
        List<Cart> cartItems = cartService.getCartItems(currentUser.getId());
        List<CartVo> res = new ArrayList<>();
        for (Cart cart : cartItems) {
            CartVo cartVo = new CartVo();
            Book book = bookService.getBookById(cart.getBookId());
            cartVo.setBookId(cart.getBookId());
            cartVo.setUserId(currentUser.getId());
            cartVo.setId(cart.getId());
            cartVo.setSum(cart.getSum());
            cartVo.setBookName(book.getBookName());
            cartVo.setPrice(book.getPrice());
            res.add(cartVo);
        }
        return Result.success(res);
    }

    @RequestMapping(value = "/reduce_item.do")
    public Result<Boolean> reduceItem(HttpServletRequest request, CartOperationReq req) {
        User currentUser = userService.getCurrentUser(request);
        if (currentUser == null) {
            Result<Boolean> error = Result.error("need login.");
            error.setCode(404);
            return error;
        }
        cartService.reduceItem(req.getBookId(), currentUser.getId());
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
        cartService.addItem(req.getBookId(), currentUser.getId());
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
            Result<Boolean> error = Result.error("need login.");
            error.setCode(404);
            return error;
        }
        cartService.deleteItem(req.getBookId(), currentUser.getId());
        return Result.success(true);
    }
}
