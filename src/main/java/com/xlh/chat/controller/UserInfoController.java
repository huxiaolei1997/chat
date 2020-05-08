package com.xlh.chat.controller;

import com.alibaba.fastjson.JSONObject;
import com.xlh.chat.annotation.AccessLimit;
import com.xlh.chat.annotation.ApiIdempotent;
import com.xlh.chat.annotation.JwtIgnore;
import com.xlh.chat.common.response.Result;
import com.xlh.chat.manager.UserManager;
import com.xlh.chat.model.dto.LoginDto;
import com.xlh.chat.model.dto.UserInfoDto;
import com.xlh.chat.model.dto.UserRelationDto;
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
    public Result login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        JSONObject result = userManager.login(loginDto, response);
        return Result.SUCCESS(result);
    }

    /**
     * 保存好友关系，为了方便测试，暂时开放此方法
     * @return
     */
    @PostMapping("/saveUserRelation")
    @JwtIgnore
    public Result saveUserRelation(@RequestBody UserRelationDto userRelationDto) {
        Boolean result = userManager.saveUserRelation(userRelationDto);
        return Result.SUCCESS(result);
    }

    /**
     * 添加好友
     * 这里需要在创建一个好友申请表，用来存放好友申请记录
     * @param userRelationDto
     * @return
     */
    @PostMapping("/addFriend")
    @JwtIgnore
    public Result addFriend(@RequestBody UserRelationDto userRelationDto) {
        // TODO
        Boolean result = userManager.saveUserRelation(userRelationDto);
        return Result.SUCCESS(result);
    }
}
