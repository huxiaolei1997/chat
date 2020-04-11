package com.xlh.chat.service;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

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
    private static final AtomicInteger onlineCount = new AtomicInteger(0);


    private static CopyOnWriteArraySet<WebSocketServer> webSocketServers = new CopyOnWriteArraySet<>();


    private Session session;

    private String sid;

    /**
     * 连接建立成功调用的方法
     *
     * @param session
     * @param sid
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        webSocketServers.add(this);
        System.out.println("有新窗口开始监听" + sid + "，当前在线人数为" + onlineCount.incrementAndGet());
        this.sid = sid;

    }

    @OnClose
    public void onClose() {
        webSocketServers.remove(this);
        System.out.println("有一连接关闭，当前在线人数" + onlineCount.decrementAndGet());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("收到来自窗口" + sid + "的信息：" + message);
        // 群发消息
        for (WebSocketServer webSocketServer : webSocketServers) {
            webSocketServer.sendMessage(message);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 推送消息
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
}
