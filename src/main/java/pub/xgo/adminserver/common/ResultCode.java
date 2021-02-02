package pub.xgo.adminserver.common;

/**
 * 状态码enum
 */
public enum ResultCode {
    /**
     * 成功状态码
     */
    SUCCESS(1, "成功"),
    /**
     * 参数错误：1001～1999
     */
    PARAM_IS_BLANK(1001, "参数为空"),
    /**
     * 用户错误：2001～2999
     */
    USER_NOT_LOGGED_IN(2001, "用户未登录"),
    /**
     * 业务错误：3001～3999
     */
    /**
     * 其他异常：4001～4999
     */
    NULL_POINTER_ERROR(4888, "系统特殊异常"),
    SYSTEM_ERROR(4999, "系统异常");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
