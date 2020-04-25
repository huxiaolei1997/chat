package com.xlh.chat.service;

import com.xlh.chat.model.UserInfo;

import java.util.List;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月12日 18:58 胡晓磊 Exp $
 */
public interface UserInfoService {
    int insert(UserInfo userInfo);


    Long insertSelectiveReturnId(UserInfo userInfo);

    int update(UserInfo userInfo);

    int delete(Long id);

    List<UserInfo> select(UserInfo userInfo);

    UserInfo select(Long id);

    /**
     * 根据手机号查找用户信息
     *
     * @param phone
     * @return
     */
    UserInfo selectByPhone(String phone);
}
