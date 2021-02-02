package pub.xgo.adminserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pub.xgo.adminserver.common.BusinessException;
import pub.xgo.adminserver.common.Result;
import pub.xgo.adminserver.common.ResultCode;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result businessExceptionHandler(HttpServletRequest request, BusinessException e) {
        log.error("业务异常！原因是：{}", e.getErrorMessage());
        return Result.failure(e.getErrorCode(), e.getErrorMessage());
    }

    /**
     * 空指针异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Result nullPointerExceptionHandler(HttpServletRequest request, NullPointerException e) {
        log.error("空指针 : ", e);
        return Result.failure(ResultCode.NULL_POINTER_ERROR);
    }

    /**
     * 系统异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("未知异常！原因是：", e);
        return Result.failure(ResultCode.SYSTEM_ERROR);
    }
}
