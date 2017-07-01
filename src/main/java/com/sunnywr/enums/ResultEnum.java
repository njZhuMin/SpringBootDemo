package com.sunnywr.enums;

public enum ResultEnum {
    UNDEFINED_ERROR(-1, "Undefined error"),
    SUCCESS(0, "Success"),
    RANGE_0_20(20, "Price 0-20"),
    RANGE_20_30(30, "Price 20-30"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
