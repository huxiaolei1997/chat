package com.xlh.chat.manager;

import com.xlh.chat.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * token 生成
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月26日 22:31 胡晓磊 Exp $
 */
@Service
public class TokenManager {

    @Autowired
    private TokenService tokenService;

    public String createToken() {
        return tokenService.createToken();
    }
}
