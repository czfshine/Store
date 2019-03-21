package cn.czfshine.app.store.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 实体未找到，抛出404和提示信息
 * @author:czfshine
 * @date:2019/3/21 20:44
 */

@ControllerAdvice
public class NotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(Exception.class) //todo：弄个父类
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String NotFoundHandler(Exception ex){
        return ex.getMessage();
    }
}
