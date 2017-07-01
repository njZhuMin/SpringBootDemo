package com.sunnywr.handle;

import com.sunnywr.exception.BookException;
import com.sunnywr.model.Result;
import com.sunnywr.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class MyExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        if(e instanceof BookException) {
            BookException exception = (BookException) e;
            return ResultUtil.errorValidation(exception.getErrCode(), exception.getMessage());
        } else {
            logger.error("[system exception] {}", e);
            return ResultUtil.errorValidation(-1, "Undefined error.");
        }
    }
}
