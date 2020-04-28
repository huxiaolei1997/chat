package com.xlh.chat.controller;

import com.xlh.chat.annotation.JwtIgnore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月12日 19:19 胡晓磊 Exp $
 */
@Controller
public class ViewController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/wechat/index")
    @JwtIgnore
    public String wechatIndex() {
        return "wechat/index";
    }

    @GetMapping("/wechat/friends")
    @JwtIgnore
    public String wechatFriends() {
        return "wechat/friends";
    }

    @GetMapping("/wechat/install")
    @JwtIgnore
    public String wechatInstall() {
        return "wechat/install";
    }

    @GetMapping("/wechat/login")
    @JwtIgnore
    public String wechatLogin() {
        return "wechat/login";
    }

}
