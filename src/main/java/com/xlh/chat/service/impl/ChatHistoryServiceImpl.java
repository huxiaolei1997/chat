package com.xlh.chat.service.impl;

import com.xlh.chat.dao.mapper.ChatHistoryMapperExtend;
import com.xlh.chat.model.ChatHistory;
import com.xlh.chat.model.dto.ChatHistoryDto;
import com.xlh.chat.service.ChatHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年05月05日 17:54 胡晓磊 Exp $
 */
@Component
public class ChatHistoryServiceImpl implements ChatHistoryService {
    @Autowired
    private ChatHistoryMapperExtend chatHistoryMapperExtend;
    @Override
    public List<ChatHistory> findChatHistoryList(ChatHistoryDto chatHistoryDto) {
        return chatHistoryMapperExtend.selectUserOrGroupChatList(chatHistoryDto);
    }
}
