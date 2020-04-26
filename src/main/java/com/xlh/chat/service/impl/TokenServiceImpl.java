package com.xlh.chat.service.impl;

import com.xlh.chat.common.Constant;
import com.xlh.chat.common.exception.BizException;
import com.xlh.chat.common.exception.ResultCode;
import com.xlh.chat.common.response.Result;
import com.xlh.chat.service.TokenService;
import com.xlh.chat.utils.JedisUtil;
import com.xlh.chat.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

    private static final String TOKEN_NAME = "token";

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public String createToken() {
        String str = RandomUtil.UUID32();
        StringBuilder token = new StringBuilder();
        token.append(Constant.Redis.TOKEN_PREFIX).append(str);

        jedisUtil.set(token.toString(), token.toString(), Constant.Redis.EXPIRE_TIME_MINUTE);

        return token.toString();
    }

    @Override
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);

        // header中不存在token
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(TOKEN_NAME);
            // parameter中也不存在token
            if (StringUtils.isBlank(token)) {
                throw new BizException(ResultCode.REPETITIVE_OPERATION);
            }
        }

        if (!jedisUtil.exists(token)) {
            throw new BizException(ResultCode.REPETITIVE_OPERATION);
        }

        Long del = jedisUtil.del(token);
        log.info("删除的结果是 {}", del);
        if (del <= 0) {
            throw new BizException(ResultCode.REPETITIVE_OPERATION);
        }
    }

}
