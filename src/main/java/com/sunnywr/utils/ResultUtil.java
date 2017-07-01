package com.sunnywr.utils;

import com.sunnywr.model.Result;

public class ResultUtil {

    public static Result successValidation(Object object) {
        Result result = new Result();
        result.setErrCode(0);
        result.setMsg("Success");
        result.setData(object);
        return result;
    }

    public static Result successValidation() {
        Result result = new Result();
        result.setErrCode(0);
        result.setMsg("Success");
//        result.setData(null);
        return result;
    }

    public static Result errorValidation(Integer errCode, String msg) {
        Result result = new Result();
        result.setErrCode(errCode);
        result.setMsg(msg);
//        result.setData(null);
        return result;
    }
}
