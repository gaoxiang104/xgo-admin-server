package pub.xgo.adminserver.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pub.xgo.adminserver.annotation.ResponseResult;
import pub.xgo.adminserver.common.BusinessException;
import pub.xgo.adminserver.common.Result;
import pub.xgo.adminserver.common.ResultCode;

import java.util.Map;

@RestController
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
        return Result.failure(ResultCode.PARAM_IS_BLANK, dataStr);
    }

    @GetMapping(value = "/testSuccessAnnNull")
    @ResponseResult
    public void testSuccessAnnNull() {
    }

    @GetMapping(value = "/testSuccessAnn")
    @ResponseResult
    public String testSuccessAnn(@RequestParam String dataStr) {
        return dataStr;
    }

    @GetMapping(value = "/testSuccessAnnInteger")
    @ResponseResult
    public Integer testSuccessAnnInteger() {
        return 888;
    }

    @GetMapping(value = "/testSuccessAnnError1")
    @ResponseResult
    public Integer testSuccessAnnError1(@RequestParam String dataStr) {
        if (StringUtils.isBlank(dataStr)) {
            throw new BusinessException(ResultCode.PARAM_IS_BLANK);
        }
        return 888;
    }

    @GetMapping(value = "/testSuccessAnnError2")
    @ResponseResult
    public Integer testSuccessAnnError2(@RequestParam String dataStr) {
        ;
        Map<String, Object> map = null;
        map.get("111");
        return Integer.parseInt(dataStr);
    }
}
