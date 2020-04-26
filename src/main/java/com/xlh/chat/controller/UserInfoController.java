package com.xlh.chat.controller;

import com.alibaba.fastjson.JSONObject;
import com.xlh.chat.annotation.AccessLimit;
import com.xlh.chat.annotation.ApiIdempotent;
import com.xlh.chat.annotation.JwtIgnore;
import com.xlh.chat.common.response.Result;
import com.xlh.chat.manager.UserManager;
import com.xlh.chat.model.dto.LoginDto;
import com.xlh.chat.model.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月25日 17:02 胡晓磊 Exp $
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserManager userManager;

    /**
     * 添加用户
     *
     * @param userInfoDto
     * @return
     */
    @PostMapping("/save")
    @JwtIgnore
    @ApiIdempotent
    public Result save(@RequestBody UserInfoDto userInfoDto) {
        userManager.save(userInfoDto);
        return Result.SUCCESS(true);
    }

    /**
     * 登录
     *
     * @param loginDto
     * @param response
     * @return
     */
    @PostMapping("/login")
    @JwtIgnore
    @AccessLimit
    public Result login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        JSONObject result = userManager.login(loginDto, response);
        return Result.SUCCESS(result);
    }
}
