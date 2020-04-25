package com.xlh.chat.util;

import com.xlh.chat.common.exception.BizException;
import com.xlh.chat.common.exception.ResultCode;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * MD5 工具类
 *
 * @author 胡晓磊
 * @version $Id: MD5Util, v0.1
 * @company 杭州网络科技有限公司
 * @date 2018年12月24日 11:36 胡晓磊 Exp $
 */
@Slf4j
public class MD5Util {
    private static final char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private MD5Util() {
    }


    public static String encrypt(String value) {
        try {
            byte[] bytes = value.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] updateBytes = messageDigest.digest();
            int len = updateBytes.length;
            char[] myChar = new char[len * 2];
            int k = 0;

            for (int i = 0; i < len; ++i) {
                byte byte0 = updateBytes[i];
                myChar[k++] = hexDigits[byte0 >>> 4 & 15];
                myChar[k++] = hexDigits[byte0 & 15];
            }

            return new String(myChar);
        } catch (Exception e) {
            log.error("MD5加密失败 {}", e);
            throw new BizException(ResultCode.BUSINESS_MD5_ENCRYPT_FAIL);
        }
    }
}
