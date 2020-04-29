package com.xlh.chat.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月25日 20:45 胡晓磊 Exp $
 */
@Data
public class LoginDto implements Serializable {
    private static final long serialVersionUID = 7720288623715870052L;

    @Size(max = 11, message = "手机号最长为11位")
    private String phone;

    @Size(max = 32, message = "用户名最长不能超过32个字符")
    private String userName;
//
    @NotNull
    @Size(min = 8, max = 16, message = "密码长度必须在8-16位之间")
    private String password;
}
