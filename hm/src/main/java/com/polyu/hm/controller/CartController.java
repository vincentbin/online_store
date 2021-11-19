package com.polyu.hm.controller;

import com.polyu.hm.result.Result;
import com.polyu.hm.service.UserService;
import com.polyu.hm.vo.BookVo;
import com.polyu.hm.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/cart")
@RestController
public class CartController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/items")
    public Result<CartVo> getCartItems(HttpServletRequest request) {
        boolean needLogin = userService.needLogin(request);
        if (needLogin) {
            return Result.error("need login.");
        }

        // todo
        return Result.success(null);
    }


}
