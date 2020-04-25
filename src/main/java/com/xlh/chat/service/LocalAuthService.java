package com.xlh.chat.service;

import com.xlh.chat.model.LocalAuth;
import com.xlh.chat.model.UserInfo;

import java.util.List;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月12日 18:58 胡晓磊 Exp $
 */
public interface LocalAuthService {
    int insert(LocalAuth localAuth);


    int insertSelective(LocalAuth localAuth);

    /**
     * 根据用户ID查找用户登录信息
     *
     * @param userId
     * @return
     */
    LocalAuth selectByUserId(Long userId);
}
