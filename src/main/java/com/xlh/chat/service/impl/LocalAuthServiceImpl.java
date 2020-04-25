package com.xlh.chat.service.impl;

import com.xlh.chat.dao.mapper.LocalAuthMapper;
import com.xlh.chat.dao.mapper.LocalAuthMapperExtend;
import com.xlh.chat.model.LocalAuth;
import com.xlh.chat.service.LocalAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月25日 18:09 胡晓磊 Exp $
 */
@Component
public class LocalAuthServiceImpl implements LocalAuthService {
    @Autowired
    private LocalAuthMapper localAuthMapper;

    @Autowired
    private LocalAuthMapperExtend localAuthMapperExtend;

    @Override
    public int insert(LocalAuth localAuth) {
        return localAuthMapper.insert(localAuth);
    }

    @Override
    public int insertSelective(LocalAuth localAuth) {
        return localAuthMapper.insertSelective(localAuth);
    }

    @Override
    public LocalAuth selectByUserId(Long userId) {
        return localAuthMapperExtend.selectByUserId(userId);
    }
}
