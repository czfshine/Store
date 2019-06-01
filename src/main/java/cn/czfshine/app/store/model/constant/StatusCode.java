package cn.czfshine.app.store.model.constant;

/**
 * 状态码
 */
public enum StatusCode {
    success("0000"),
    paramError("4001"), //参数格式错误
    logicError("5000")  //理论上这个错误不应该发生
    ;


    private String code;

    StatusCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
