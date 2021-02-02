package pub.xgo.adminserver.common;

import lombok.Data;
import org.springframework.lang.Nullable;

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
        return new Result(ResultCode.SUCCESS, null);
    }

    public static Result success(Object data) {
        return new Result(ResultCode.SUCCESS, data);
    }

    public static Result failure(ResultCode resultCode) {
        return new Result(resultCode, null);
    }


    public static Result failure(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static Result failure(ResultCode resultCode, String... args) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        String msgFormat;
        if (null != args) {
            msgFormat = String.format(resultCode.getMessage(), args);
        } else {
            msgFormat = resultCode.getMessage();
        }
        result.setMessage(msgFormat);
        return result;
    }

}
