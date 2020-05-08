package com.xlh.chat.service.impl;

import com.xlh.chat.dao.mapper.UserRelationMapper;
import com.xlh.chat.model.UserRelation;
import com.xlh.chat.service.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年05月05日 11:43 胡晓磊 Exp $
 */
@Component
public class UserRelationServiceImpl implements UserRelationService {
    @Autowired
    private UserRelationMapper userRelationMapper;

    @Override
    public int save(UserRelation userRelation) {
        return userRelationMapper.insert(userRelation);
    }
}
