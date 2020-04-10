package com.xlh.chat.service;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月10日 22:48 胡晓磊 Exp $
 */
@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {

    /**
     * 连接建立成功调用的方法
     *
     * @param session
     * @param sid
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        
    }
}
