package com.xlh.chat.interceptor;

import com.xlh.chat.annotation.JwtIgnore;
import com.xlh.chat.common.exception.BizException;
import com.xlh.chat.common.exception.ResultCode;
import com.xlh.chat.config.Audience;
import com.xlh.chat.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jwt token 验证拦截器
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月19日 18:22 胡晓磊 Exp $
 */
@Slf4j
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private Audience audience;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if (jwtIgnore != null) {
                return true;
            }
        }

        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 获取请求头信息authorization信息
        String authHeader = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        // 获取referer，校验referer是否来自本域名
        String referer = request.getHeader("Referer");
        log.info("## authHeader= {}, uri = {}, referer = {}", authHeader, request.getRequestURI(), referer);

        if (StringUtils.isBlank(authHeader) || !authHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            log.info("### 用户未登录，请先登录 ###");
            throw new BizException(ResultCode.USER_NOT_LOGGED_IN);
        }

        // 获取token
        final String token = authHeader.substring(7);

//        if (audience == null) {
//            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
//            audience = (Audience) factory.getBean("audience");
//        }

        // 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
        JwtTokenUtil.parseJWT(token, audience.getBase64Secret());

        return true;
    }
}
