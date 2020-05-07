package com.xlh.chat.dao.mapper;

import com.xlh.chat.model.ChatHistory;
import com.xlh.chat.model.dto.ChatHistoryDto;

import java.util.List;

public interface ChatHistoryMapperExtend {
    List<ChatHistory> selectUserOrGroupChatList(ChatHistoryDto chatHistoryDto);
}
