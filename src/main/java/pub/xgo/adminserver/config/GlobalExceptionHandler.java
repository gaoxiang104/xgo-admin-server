package pub.xgo.adminserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pub.xgo.adminserver.common.BusinessException;
import pub.xgo.adminserver.common.Result;
import pub.xgo.adminserver.common.ResultCode;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result businessExceptionHandler(HttpServletRequest request, BusinessException e) {
        log.error("业务异常！原因是：{}", e.getErrorMessage());
        return Result.failure(e.getErrorCode(), e.getErrorMessage());
    }


    /**
     * request parameter缺少参数 异常处理器
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public Result handleHttpMessageNotReadableException(
            MissingServletRequestParameterException e) {
        return Result.failure(ResultCode.PARAM_IS_MISS, e.getParameterName());
    }

    /**
     * request body为空 异常处理器
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Result handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        return Result.failure(ResultCode.PARAM_IS_NULL);
    }

    /**
     * valid校验 异常处理器
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        if (0 < errors.size()) {
            log.error("handleValidationExceptions error : {}", errors.get(0).getDefaultMessage());
            return Result.failure(ResultCode.PARAM_IS_ERROR, errors.get(0).getDefaultMessage());
        }
        return Result.failure(ResultCode.PARAM_IS_ERROR);
    }


    /**
     * 空指针异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Result nullPointerExceptionHandler(HttpServletRequest request, NullPointerException e) {
        log.error("空指针 : ", e);
        return Result.failure(ResultCode.NULL_POINTER_ERROR);
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("未知异常！原因是：", e);
        return Result.failure(ResultCode.SYSTEM_ERROR);
    }
}
