package com.xlh.chat.common.exception.handler;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月19日 19:45 胡晓磊 Exp $
 */

import com.xlh.chat.common.exception.BizException;
import com.xlh.chat.common.exception.ResultCode;
import com.xlh.chat.common.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局异常处理器
 *
 * @author hxl
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(BizException.class)
    public Result handleException(BizException e) {
        // 打印异常信息
        log.error("### 异常信息:{} ###", e.getMessage());
        return Result.FAIL(e.getResultCode());
    }

    /**
     * 参数错误异常
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public Result handleException(Exception e) {

        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException validException = (MethodArgumentNotValidException) e;
            BindingResult result = validException.getBindingResult();
            StringBuffer errorMsg = new StringBuffer();
            if (result.hasErrors()) {
                List<ObjectError> errors = result.getAllErrors();
                errors.forEach(p -> {
                    FieldError fieldError = (FieldError) p;
                    errorMsg.append(fieldError.getDefaultMessage()).append(",");
                    log.error("### 请求参数错误：{},field: {},errorMessage: {}", fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
                });
            }
        } else if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            if (bindException.hasErrors()) {
                log.error("### 请求参数错误: {}", bindException.getAllErrors());
            }
        }

        return Result.FAIL(ResultCode.PARAM_IS_INVALID);
    }

    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleOtherException(Exception e) {
        //打印异常堆栈信息
        e.printStackTrace();
        // 打印异常信息
        log.error("### 不可知的异常:{} ###", e.getMessage());
        return Result.FAIL(ResultCode.SYSTEM_INNER_ERROR);
    }

}
