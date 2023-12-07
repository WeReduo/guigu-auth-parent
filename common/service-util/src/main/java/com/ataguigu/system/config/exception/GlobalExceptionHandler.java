package com.ataguigu.system.config.exception;

import com.ataguigu.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Result error(Exception e){
//        e.printStackTrace();
//
//        return Result.fail().message("全局异常执行。。。");
//    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        e.printStackTrace();
        return Result.fail().message("执行特定异常。。。");
    }
    @ExceptionHandler(GuiguException.class)
    @ResponseBody
    public Result error(GuiguException e2) {
        e2.printStackTrace();
        return Result.fail().code(e2.getCode()).message(e2.getMessage());
    }
}