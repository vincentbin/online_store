package com.polyu.hm;

import com.polyu.hm.common.util.JsonUtil;
import com.polyu.hm.common.util.RedisUtil;
import com.polyu.hm.dao.UserRepository;
import com.polyu.hm.mapper.BookMapper;
import com.polyu.hm.mapper.CartMapper;
import com.polyu.hm.mapper.UserMapper;
import com.polyu.hm.model.Book;
import com.polyu.hm.model.Cart;
import com.polyu.hm.model.User;
import com.polyu.hm.service.BookService;
import com.polyu.hm.service.UserService;
import com.polyu.hm.vo.RegisterVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HmApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
        User user = userMapper.selectById(1);
        System.out.println("user = " + user);

        List<Book> books = bookMapper.selectList(null);
        System.out.println("books = " + books);

        List<Cart> carts = cartMapper.selectList(null);
        System.out.println("carts = " + carts);
    }

    @Test
    void contextLoads1() {
        redisUtil.set("aaa", JsonUtil.objectToJson(new Book()), 10000L);
        Object aaa = redisUtil.get("aaa");
        JsonUtil.jsonToPojo((String) aaa, Book.class);
        System.out.println("aaa = " + aaa);
    }

    @Test
    void contextLoads2() {
        User test = userRepository.getById("test");
        System.out.println("test = " + test);
    }

    @Test
    void contextLoads3() {
        User test = userService.getUserByMobile("test");
        System.out.println("test = " + test);
    }

    @Test
    void contextLoads4() {
        RegisterVo registerVo = new RegisterVo();
        registerVo.setUserName("yanyibin");
        registerVo.setPassWord("12345");
        boolean register = userService.register(registerVo);
        System.out.println("register = " + register);
    }

    @Test
    void contextLoads5() {
        List<Book> allBook = bookService.getAllBook();
        System.out.println("books = " + allBook);
    }

    @Test
    void contextLoads6() {
        Book book = bookService.getBookById(1);
        System.out.println("book = " + book);
    }

}
