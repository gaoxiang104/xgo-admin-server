package pub.xgo.adminserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pub.xgo.adminserver.annotation.ResponseResult;
import pub.xgo.adminserver.common.BusinessException;
import pub.xgo.adminserver.common.RequestContext;
import pub.xgo.adminserver.common.Result;
import pub.xgo.adminserver.common.ResultCode;
import pub.xgo.adminserver.model.vo.AdminVo;

import javax.servlet.http.HttpSession;

/**
 * session 登录
 */
@Slf4j
@ResponseResult
@RestController
public class SessionController {

    @PostMapping(value = "/login")
    public String login(@RequestBody AdminVo adminVo, HttpSession session) {
        if (null != adminVo && "admin".equals(adminVo.getName())
                && "password".equals(adminVo.getPassword())) {
            session.setAttribute("admin", adminVo);
            return "登录成功";
        } else {
            throw new BusinessException(ResultCode.USER_LOGGING_ERROR);
        }
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        return "退出登录";
    }

    @GetMapping("/api")
    public AdminVo api(HttpSession session) {
        // 模拟各种api，访问之前都要检查有没有登录，没有登录就提示用户登录
        AdminVo adminVo = RequestContext.getCurrentUser();;
        // 如果有登录就调用业务层执行业务逻辑，然后返回数据
        return adminVo;
    }



}
