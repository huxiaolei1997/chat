package com.xlh.chat.handler;

import com.xlh.chat.config.WebSocketPool;
import lombok.extern.slf4j.Slf4j;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月12日 19:10 胡晓磊 Exp $
 */
@Slf4j
public class WebSocketHandler {

    /**
     * 给单个用户发消息
     * @param session
     * @param msg
     */
    public static void sendMessage(Session session, String msg) {
        if (null == session) {
            return;
        }

        RemoteEndpoint.Basic basic = session.getBasicRemote();

        if (null == basic) {
            return;
        }

        try {
            basic.sendText(msg);
        } catch (IOException e) {
            log.error("发送消息失败 {},{}", session, e);
        }
    }

    /**
     * 给所有在线的用户发消息
     * @param message
     */
    public static void sendMessageAll(String message) {
        log.info("群发消息：{}", message);
        WebSocketPool.getOnlineUserSessionMap().forEach((key, session) -> {
            sendMessage(session, message);
        });
    }
}
