package com.xlh.chat.common.exception;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年04月19日 17:53 胡晓磊 Exp $
 */
public class BizException extends RuntimeException {
    private ResultCode resultCode;

    /**
     * Getter method for property <tt>resultCode</tt>.
     *
     * @return property value of resultCode
     */
    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }


    public BizException(ResultCode code) {
        super(code.message());
        this.resultCode = code;
    }

    public BizException(Throwable cause, ResultCode code) {
        super(code.message(), cause);
        this.resultCode = code;
    }


    public BizException(Throwable cause, boolean enableSuppression, boolean writableStackTrace, ResultCode code) {
        super(code.message(), cause, enableSuppression, writableStackTrace);
        this.resultCode = code;
    }
}
