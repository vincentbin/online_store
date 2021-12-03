package com.polyu.hm.service;

import com.polyu.hm.common.util.RedisUtil;
import com.polyu.hm.common.util.UUIDUtil;
import com.polyu.hm.dao.UserRepository;
import com.polyu.hm.model.User;
import com.polyu.hm.vo.LoginVo;
import com.polyu.hm.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserService {

    private static final String COOKIE_NAME_TOKEN = "user_token";

    private static final String REDIS_USER_TOKEN_KEY_PREFIX = "UserKey+";

    private static final String REDIS_USER_KEY_PREFIX = "UserIdKey+";

    private static final int TTL = 3600 * 24 * 2;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserRepository userRepository;

    public User getUserByMobile(String mobilePhone) {
        //取缓存
        User user = (User) redisUtil.get(REDIS_USER_KEY_PREFIX + mobilePhone);
        if (user != null) {
            return user;
        }
        user = userRepository.getById(mobilePhone);
        if (user != null) {
            redisUtil.set(REDIS_USER_KEY_PREFIX + mobilePhone, user);
        }
        return user;
    }

    /**
     * 登录
     * @param response
     * @param loginVo
     * @return
     */
    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            return false;
        }
        String userName = loginVo.getUserName();
        String passWord = loginVo.getPassWord();
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(passWord)) {
            return false;
        }
        User user = this.getUserByMobile(userName);
        if (user == null) {
            return false;
        }
        String realPassWord = user.getPassWord();
        if (!passWord.equals(realPassWord)) {
            return false;
        }
        String token = UUIDUtil.uuid();
        this.addCookie(response, user, token);
        return true;
    }

    /**
     * 注册
     * @return
     */
    public boolean register(RegisterVo registerVo) {
        User user = new User();
        user.setUserName(registerVo.getUserName());
        user.setPassWord(registerVo.getPassWord());
        return userRepository.insert(user);
    }

    /**
     * token给客户端 避免重复登录
     * @param response
     * @param user
     * @param token
     */
    private void addCookie(HttpServletResponse response, User user, String token) {
        redisUtil.set(REDIS_USER_TOKEN_KEY_PREFIX + token, user, TTL);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setPath("/");
        cookie.setMaxAge(TTL);
        response.addCookie(cookie);
    }

    /**
     * 是否需要重新登陆
     * @param request
     * @return
     */
    public boolean needLogin(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (COOKIE_NAME_TOKEN.equals(cookie.getName())) {
                String token = cookie.getValue();
                User user = (User) redisUtil.get(REDIS_USER_TOKEN_KEY_PREFIX + token);
                if (user != null) {
                    return false;
                }
                break;
            }
        }
        return true;
    }

    /**
     * 获取当前用户信息
     * @param request
     * @return
     */
    public User getCurrentUser(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (COOKIE_NAME_TOKEN.equals(cookie.getName())) {
                    String token = cookie.getValue();
                    User user = (User) redisUtil.get(REDIS_USER_TOKEN_KEY_PREFIX + token);
                    if (user != null) {
                        return user;
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
