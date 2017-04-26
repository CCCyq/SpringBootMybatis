package com.config.web;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ControllerAdvice 是一个controller层的切片
 * @ExceptionHandler 遇到异常 统一返回
 *
 * 还有2个注解 ，目前还没用到
 * @ModelAttribute 在方法上添加，意味着所有的controller层的所有方法都可以自动装配这个类的实例。
 * @InitBinder 特殊类型转换时，需要指定转换方式，如String转Data。
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResult errorHandler(HttpServletRequest req, Exception e) {
        if (e instanceof BusinessException) {
            logger.error("---BusinessException Handler---", e);
            return ApiResult.failed(((BusinessException) e).getCode(), e.getMessage());
        } else {
            logger.error("---Exception Handler---", e);
            return ApiResult.failed("服务器内部异常");
        }
    }
}
