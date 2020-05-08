package com.xlh.chat.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserRelationDto implements Serializable {

    private static final long serialVersionUID = 693057965268781235L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 好友id
     */
    @NotNull
    private Long friendId;
}
