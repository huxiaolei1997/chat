package com.xlh.chat.service.impl;

import com.xlh.chat.dao.mapper.UserInfoMapper;
import com.xlh.chat.dao.mapper.UserInfoMapperExtend;
import com.xlh.chat.model.UserInfo;
import com.xlh.chat.model.UserInfoExample;
import com.xlh.chat.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月12日 18:58 胡晓磊 Exp $
 */
@Component
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserInfoMapperExtend userInfoMapperExtend;

    @Override
    public int insert(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public int update(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public int delete(Long id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Long insertSelectiveReturnId(UserInfo userInfo) {
        return userInfoMapperExtend.insertSelectiveReturnId(userInfo);
    }

    @Override
    public List<UserInfo> select(UserInfo userInfo) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();

        if (StringUtils.isNotBlank(userInfo.getPhone())) {
            criteria.andPhoneEqualTo(userInfo.getPhone());
        }

        return userInfoMapper.selectByExample(userInfoExample);
    }

    @Override
    public UserInfo select(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserInfo selectByPhone(String phone) {
        return userInfoMapperExtend.selectByPhone(phone);
    }
}
