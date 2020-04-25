package com.xlh.chat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月10日 22:48 胡晓磊 Exp $
 */
@ServerEndpoint("/websocket/{userId}")
@Component
@Slf4j
public class WebSocketServerEndPoint {
    // 在线人数，目前放在这里，后续可以考虑放到Redis中
    private static final AtomicInteger onlineCount = new AtomicInteger(0);


    private static CopyOnWriteArraySet<WebSocketServerEndPoint> webSocketServerEndPoints = new CopyOnWriteArraySet<>();


    private Session session;

    private Long userId;

    private static UserInfoService userInfoService;

    public void setUserService(@Autowired UserInfoService userInfoService) {
        WebSocketServerEndPoint.userInfoService = userInfoService;
    }


    // 这里需要注意的是，每当有新的websocket连接被创建的时候，当前类会重新创建一个实例，如果需要注入实例，不能直接使用@Autowired注入
    // 需要把要注入的实例设置为静态变量，并且通过set方法注入

    /**
     * 连接建立成功调用的方法
     *
     * @param session
     * @param userId
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") Long userId) {
        this.session = session;
        webSocketServerEndPoints.add(this);
        System.out.println("有新窗口开始监听" + userId + "，当前在线人数为" + onlineCount.incrementAndGet());
//        log.info("有新窗口开始监听");
        this.userId = userId;

    }

    @OnClose
    public void onClose() {
        webSocketServerEndPoints.remove(this);
        System.out.println("有一连接关闭，当前在线人数" + onlineCount.decrementAndGet());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("收到来自窗口" + userId + "的信息：" + message);
        // 群发消息
        for (WebSocketServerEndPoint webSocketServerEndPoint : webSocketServerEndPoints) {
            webSocketServerEndPoint.sendMessage(message);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("连接发生异常 {}", error);
        try {
            session.close();
        } catch (Exception e) {
            log.error("关闭连接发生异常 {}", error);
        }
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
