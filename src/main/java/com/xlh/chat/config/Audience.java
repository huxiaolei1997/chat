package com.xlh.chat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT 配置类
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月19日 17:38 胡晓磊 Exp $
 */
@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class Audience {
    private String clientId;

    private String base64Secret;

    private String name;

    private int expiresSecond;
}
