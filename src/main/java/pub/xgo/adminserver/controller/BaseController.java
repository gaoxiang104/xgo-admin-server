package pub.xgo.adminserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import pub.xgo.adminserver.annotation.ResponseResult;
import pub.xgo.adminserver.common.BusinessException;
import pub.xgo.adminserver.common.Result;
import pub.xgo.adminserver.common.ResultCode;
import pub.xgo.adminserver.model.vo.UserVo;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@ResponseResult
@RequestMapping("/base")
public class BaseController {

    @GetMapping("/testSuccess")
    public Result testSuccess() {
        return Result.success();
    }

    @GetMapping("/testSuccessData")
    public Result testSuccessData(@RequestParam String dataStr) {
        return Result.success(dataStr);
    }

    @GetMapping("/testFailure")
    public Result testFailure() {
        return Result.failure(ResultCode.SYSTEM_ERROR);
    }

    @GetMapping("/testFailureData")
    public Result testFailureData(@RequestParam String dataStr) {
        return Result.failure(ResultCode.PARAM_IS_ERROR, dataStr);
    }

    @GetMapping(value = "/testSuccessAnnNull")
    public void testSuccessAnnNull() {
    }

    @GetMapping(value = "/testSuccessAnn")
    public String testSuccessAnn(@RequestParam String dataStr) {
        return dataStr;
    }

    @GetMapping(value = "/testSuccessAnnInteger")
    public Integer testSuccessAnnInteger() {
        return 888;
    }

    @GetMapping(value = "/testSuccessAnnError1")
    public Integer testSuccessAnnError1(@RequestParam String dataStr) {
        if (StringUtils.isBlank(dataStr)) {
            throw new BusinessException(ResultCode.PARAM_IS_ERROR);
        }
        return 888;
    }

    @GetMapping(value = "/testSuccessAnnError2")
    public Integer testSuccessAnnError2(@RequestParam String dataStr) {
        Map<String, Object> map = null;
        map.get("111");
        return Integer.parseInt(dataStr);
    }

    @PostMapping(value = "/validUser")
    public UserVo validUser(@RequestBody @Valid UserVo userVo) {
        log.info("input user : {}", userVo);
        return userVo;
    }

    @GetMapping(value = "/validParameterIsNull")
    public String validParameterIsNull(@RequestParam String id ) {
        log.info("validParameterIsNull id : {}", id);
        return id;
    }
}
