package com.xlh.chat.config;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * websocket 连接池
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月12日 19:05 胡晓磊 Exp $
 */
@Slf4j
public class WebSocketPool {
    /**
     * 在线用户连接池
     */
    private static final Map<Long, Session> ONLINE_USER_SESSIONS = new ConcurrentHashMap<>(16);


    /**
     * 添加连接
     *
     * @param key
     * @param session
     */
    public static void add(Long key, Session session) {
        if (null != key && null != session) {
            ONLINE_USER_SESSIONS.put(key, session);
        }
    }

    /**
     * 移除连接
     *
     * @param key
     */
    public static void remove(Long key) {
        if (null != key) {
            ONLINE_USER_SESSIONS.remove(key);
        }
    }

    /**
     * 获取在线人数
     *
     * @return
     */
    public static int count() {
        return ONLINE_USER_SESSIONS.size();
    }

    /**
     * 获取在线session池
     *
     * @return
     */
    public static Map<Long, Session> getOnlineUserSessionMap() {
        return ONLINE_USER_SESSIONS;
    }

}
