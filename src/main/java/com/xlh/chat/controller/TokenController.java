package com.xlh.chat.controller;

import com.xlh.chat.common.response.Result;
import com.xlh.chat.manager.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenManager tokenManager;

    @GetMapping("/generate")
    public Result token() {
        return Result.SUCCESS(tokenManager.createToken());
    }

}
