package com.xlh.chat.utils;

import com.xlh.chat.common.exception.BizException;
import com.xlh.chat.common.exception.ResultCode;
import com.xlh.chat.config.Audience;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * JWT 工具类
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月19日 17:42 胡晓磊 Exp $
 */
@Slf4j
@Component
public class JwtTokenUtil {
    public static final String AUTH_HEADER_KEY = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    @Autowired
    private Audience audience;

    /**
     * 解析JWT
     *
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();

            return claims;
        } catch (ExpiredJwtException e) {
            log.error("=== Token 过期 ===", e);
            throw new BizException(ResultCode.PERMISSION_TOKEN_EXPIRED);
        } catch (Exception e) {
            log.error("=== token 解析异常 ===", e);
            throw new BizException(ResultCode.PERMISSION_TOKEN_INVALID);
        }
    }


    /**
     * 构建JWT
     *
     * @param userId
     * @param userName
     * @param role
     * @param audience
     * @return
     */
    public static String createJWT(String userId, String userName, String role, Audience audience) {
        try {
            // 使用HS256
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

            long currentMillis = System.currentTimeMillis();

            Date now = new Date(currentMillis);

            // 生成签名密钥
            byte[] apiKeySecretsBytes = DatatypeConverter.parseBase64Binary(audience.getBase64Secret());
            Key signingKey = new SecretKeySpec(apiKeySecretsBytes, signatureAlgorithm.getJcaName());

            //
            String encryId = Base64Util.encode(userId);

            // 添加构成JWT的参数
            JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                    .claim("role", role)
                    .claim("userId", encryId)
                    .setSubject(userName)
                    .setIssuedAt(new Date())
                    .setAudience(audience.getName())
                    .signWith(signatureAlgorithm, signingKey);

            // 添加token过期时间
            int expireTimes = audience.getExpiresSecond();

            if (expireTimes > 0) {
                long expireMillis = currentMillis + expireTimes;
                // 是一个时间戳，代表这个JWT的过期时间；
                Date exp = new Date(expireMillis);
                // now // 是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的
                builder.setExpiration(exp).setNotBefore(now);
            }

            // 生成JWT
            return builder.compact();
        } catch (Exception e) {
            log.error("签名失败", e);
            throw new BizException(ResultCode.PERMISSION_SIGNATURE_ERROR);
        }
    }

    /**
     * 从token中获取用户名
     *
     * @param token
     * @param base64Security
     * @return
     */
    public static String getUserName(String token, String base64Security) {
        return parseJWT(token, base64Security).getSubject();
    }

    /**
     * 从token中获取用户ID
     *
     * @param token
     * @param base64Security
     * @return
     */
    public static String getUserId(String token, String base64Security) {
        String userId = parseJWT(token, base64Security).get("userId", String.class);
        return Base64Util.decode(userId);
    }

    /**
     * 是否已过期
     *
     * @param token
     * @param base64Security
     * @return
     */
    public static boolean isExpiration(String token, String base64Security) {
        return parseJWT(token, base64Security).getExpiration().before(new Date());
    }

    /**
     * 获取token
     *
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        // 获取请求头信息authorization信息
        String authHeader = request.getHeader(AUTH_HEADER_KEY);
        // 获取referer，校验referer是否来自本域名
        String referer = request.getHeader("Referer");
        log.info("## authHeader= {}, uri = {}, referer = {}", authHeader, request.getRequestURI(), referer);

        if (StringUtils.isBlank(authHeader) || !authHeader.startsWith(TOKEN_PREFIX)) {
            log.info("### 用户未登录，请先登录 ###");
            throw new BizException(ResultCode.USER_NOT_LOGGED_IN);
        }

        // 获取token
        String token = authHeader.substring(7);

        return token;
    }

    /**
     * 获取userId
     *
     * @return
     */
    public Long getUserId(HttpServletRequest request) {
        return Long.valueOf(getUserId(getToken(request), audience.getBase64Secret()));
    }
}
