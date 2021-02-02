package pub.xgo.adminserver.common;

import lombok.Data;

/**
 * 自定义业务异常
 */
@Data
public class BusinessException extends RuntimeException {
    private Integer errorCode;
    private String errorMessage;

    public BusinessException() {
        super();
    }

    public BusinessException(ResultCode code) {
        super(code.getCode().toString());
        this.errorCode = code.getCode();
        this.errorMessage = code.getMessage();
    }

    public BusinessException(ResultCode code, Throwable cause) {
        super(code.getCode().toString(), cause);
        this.errorCode = code.getCode();
        this.errorMessage = code.getMessage();
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

}
