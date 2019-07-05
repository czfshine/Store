package cn.czfshine.app.store.web.controller;

import cn.czfshine.app.store.exception.ApiResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 在调用/api下的查询未找到资源时会跳到这个controller来.
 * 即抛出ApiResourceNotFoundException异常
 * 返回404的语义编码即可
 *
 * @author:czfshine
 * @date:2019/3/26 11:38
 * @see ApiResourceNotFoundException
 */

@ControllerAdvice
public class ApiResourceNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ApiResourceNotFoundException.class) //对应的异常
    @ResponseStatus(HttpStatus.NOT_FOUND)
        //状态码 404
    String employeeNotFoundHandler(ApiResourceNotFoundException ex) {
        return ex.getMessage(); //todo 详细信息
    }

}
