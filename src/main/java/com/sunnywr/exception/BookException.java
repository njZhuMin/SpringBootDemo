package com.sunnywr.exception;

import com.sunnywr.enums.ResultEnum;

public class BookException extends  RuntimeException {

    private Integer errCode;

    public BookException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.errCode = resultEnum.getCode();
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }
}
