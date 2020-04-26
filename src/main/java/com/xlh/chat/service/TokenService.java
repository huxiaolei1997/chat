package com.xlh.chat.service;

import com.xlh.chat.common.response.Result;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    Result createToken();

    void checkToken(HttpServletRequest request);

}
