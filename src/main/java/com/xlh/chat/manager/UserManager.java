package com.xlh.chat.manager;

import com.alibaba.fastjson.JSONObject;
import com.xlh.chat.common.exception.BizException;
import com.xlh.chat.common.exception.ResultCode;
import com.xlh.chat.config.Audience;
import com.xlh.chat.model.LocalAuth;
import com.xlh.chat.model.UserInfo;
import com.xlh.chat.model.dto.LoginDto;
import com.xlh.chat.model.dto.UserInfoDto;
import com.xlh.chat.service.LocalAuthService;
import com.xlh.chat.service.UserInfoService;
import com.xlh.chat.utils.DateUtil;
import com.xlh.chat.utils.JwtTokenUtil;
import com.xlh.chat.utils.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * 用户信息
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月25日 17:13 胡晓磊 Exp $
 */
@Service
public class UserManager {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LocalAuthService localAuthService;

    @Autowired
    private Audience audience;

    /**
     * 保存用户信息
     *
     * @param userInfoDto
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean save(UserInfoDto userInfoDto) {
        String password = userInfoDto.getPassword();

        Timestamp currentTimestamp = DateUtil.getCurTimestamp();

        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDto, userInfo);
        userInfo.setCreateTime(currentTimestamp);

        // 盐值
        String salt = MD5Util.encrypt(UUID.randomUUID().toString());
        // 加密后的密码
        String encryptPassword = MD5Util.encrypt(MD5Util.encrypt(password + salt) + salt);

        // 添加基础用户信息
        Long userId = userInfoService.insertSelectiveReturnId(userInfo);

        if (null == userId) {
            throw new BizException(ResultCode.SAVE_USER_INFO_ERROR);
        }

        // 添加用户密码等信息
        LocalAuth localAuth = new LocalAuth();
        localAuth.setUserId(userId);
        localAuth.setUserName(userInfoDto.getUserName());
        localAuth.setPassword(encryptPassword);
        localAuth.setCreateTime(currentTimestamp);
        localAuth.setSalt(salt);
        localAuthService.insertSelective(localAuth);

        return true;
    }


    /**
     * 登录信息校验
     *
     * @param loginDto
     * @return
     */
    public JSONObject login(LoginDto loginDto, HttpServletResponse response) {
        String phone = loginDto.getPhone();

        UserInfo userInfo = userInfoService.selectByPhone(phone);

        if (null == userInfo) {
            // 发送短信，校验成功后注册该用户

        }

        Long userId = userInfo.getId();

        LocalAuth localAuth = localAuthService.selectByUserId(userId);


        String password = localAuth.getPassword();

        String loginPassword = loginDto.getPassword();

        String salt = localAuth.getSalt();
        String encryptPassword = MD5Util.encrypt(MD5Util.encrypt(loginPassword + salt) + salt);

        // 如果密码校验成功，则证明可以登录，生成JWT令牌
        // 将token响应给客户端
        JSONObject result = new JSONObject();
        if (encryptPassword.equals(password)) {
            String token = JwtTokenUtil.createJWT(String.valueOf(userId), userInfo.getNickName(), "normal_user", audience);

            // 跨域的时候设置允许访问此header
            response.setHeader("Access-Control-Expose-Headers", JwtTokenUtil.AUTH_HEADER_KEY);
            // 将token放在响应头
            response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
            result.put("token", token);
        }

        return result;
    }
}
