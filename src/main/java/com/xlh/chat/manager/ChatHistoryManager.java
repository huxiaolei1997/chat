package com.xlh.chat.manager;

import com.xlh.chat.common.response.Result;
import com.xlh.chat.dao.mapper.ChatHistoryMapperExtend;
import com.xlh.chat.model.ChatHistory;
import com.xlh.chat.model.dto.ChatHistoryDto;
import com.xlh.chat.service.ChatHistoryService;
import com.xlh.chat.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 聊天历史记录 manager
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年05月05日 12:37 胡晓磊 Exp $
 */
@Service
public class ChatHistoryManager {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ChatHistoryService chatHistoryService;

    /**
     * 获取用户聊天历史记录
     *
     * @param request
     * @return
     */
    public Result findUserOrGroupList(HttpServletRequest request) {
        // 从 jwt token 里获取 userId
        Long userId = jwtTokenUtil.getUserId(request);

        // 获取聊天历史记录列表
        ChatHistoryDto chatHistoryDto = new ChatHistoryDto();
        chatHistoryDto.setSendUserId(userId);
        List<ChatHistory> chatHistoryList = chatHistoryService.findChatHistoryList(chatHistoryDto);
        return Result.SUCCESS(chatHistoryList);
    }
}
