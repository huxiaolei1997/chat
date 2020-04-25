package com.xlh.chat.dao.mapper;

import com.xlh.chat.model.LocalAuth;
import com.xlh.chat.model.LocalAuthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LocalAuthMapperExtend {
    /**
     * 根据 userId 查找用户信息
     *
     * @param userId
     * @return
     */
    LocalAuth selectByUserId(Long userId);


}
