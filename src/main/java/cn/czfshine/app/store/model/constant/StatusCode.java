package cn.czfshine.app.store.model.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 状态码
 * modified by xuming @date:2019/06/01
 * 原来的code是String类型,BasicResponse里面的code是Integer.
 * 在调用BasicResponse类对象的setCode()方法时会出错
 * 状态码用int更合适
 * 添加lombok三个注解
 */
@Getter
public enum StatusCode {
//    原来的写法
//    success("0000"),
//    paramError("4001"), //参数格式错误
//    logicError("5000"),  //理论上这个错误不应该发生
//    ORDERITEM_EMPTY_ERROR("5001")  //订单项为空错误
//    ;
//
//
//    private String code;
//
//    StatusCode(String code) {
//        this.code = code;
//    }
//
//    public String getCode() {
//        return code;
//    }

    //大写
    SUCCESS(0000,"请求成功"),
    PARAM_ERROR(4001,"参数错误"),
    LOGIC_ERROR(5000,"逻辑错误"),
    ORDERITEM_EMPTY_ERROR(5001,"订单项为空错误");
    private int code;
    private String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
