package com.xlh.chat.service;

import com.xlh.chat.model.ChatHistory;
import com.xlh.chat.model.dto.ChatHistoryDto;

import java.util.List;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年05月05日 17:54 胡晓磊 Exp $
 */
public interface ChatHistoryService {
    List<ChatHistory> findChatHistoryList(ChatHistoryDto chatHistoryDto);
}
