package com.polyu.hm.controller;

import com.polyu.hm.result.Result;
import com.polyu.hm.service.UserService;
import com.polyu.hm.vo.LoginVo;
import com.polyu.hm.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/do_login.do")
    public Result<Boolean> doLogin(HttpServletResponse response, LoginVo loginVo) {
        boolean success = userService.login(response, loginVo);
        return Result.success(success);
    }

    @RequestMapping("/aaa.json")
    public Result<String> doLogin1(HttpServletRequest request) {
        String asd = request.getParameter("asd");
        return Result.success(asd);
    }

    @RequestMapping("/do_register.do")
    public Result<Boolean> doRegister(RegisterVo registerVo) {
        boolean success = userService.register(registerVo);
        return Result.success(success);
    }

}
