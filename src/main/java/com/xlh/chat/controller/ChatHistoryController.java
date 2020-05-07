package com.xlh.chat.controller;

import com.xlh.chat.annotation.ApiIdempotent;
import com.xlh.chat.common.response.Result;
import com.xlh.chat.manager.ChatHistoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 聊天历史记录
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月11日 21:17 胡晓磊 Exp $
 */
@RestController
@RequestMapping("/chatHistory")
public class ChatHistoryController {

    @Autowired
    private ChatHistoryManager chatHistoryManager;

    /**
     * 获取聊天用户列表（先从本地获取，如果在新设备上登录，那么再调用此接口）
     *
     * @param request
     * @return
     */
    @GetMapping("/userOrGroupList")
    public Result userOrGroupList(HttpServletRequest request) {
        Result result = chatHistoryManager.findUserOrGroupList(request);
        return result;
    }
}
