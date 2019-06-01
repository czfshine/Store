package cn.czfshine.app.store.model.dto;

import lombok.Data;

/**
 * api 通用的返回值
 */
@Data
public class BasicResponse {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态消息
     */
    private String message;

    /**
     * 待返回的主体数据
     */
    private Object data;

}
