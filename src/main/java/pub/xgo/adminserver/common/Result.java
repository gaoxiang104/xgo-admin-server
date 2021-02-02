package pub.xgo.adminserver.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 7698200217825419775L;

    private Integer code;

    private String message;

    private Object data;

    public Result() {

    }

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public static Result success() {
        Result result = new Result(ResultCode.SUCCESS, null);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result(ResultCode.SUCCESS, data);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result(resultCode, null);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result(resultCode, data);
        return result;
    }

    public static Result failure(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static Result failure(Integer code, String message, String... args) {
        Result result = new Result();
        result.setCode(code);
        String msgFormat = String.format(message, args);
        result.setMessage(msgFormat);
        return result;
    }

}
