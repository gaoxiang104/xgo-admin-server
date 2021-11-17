package pub.xgo.adminserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import pub.xgo.adminserver.common.BusinessException;
import pub.xgo.adminserver.common.ResultCode;
import pub.xgo.adminserver.model.vo.AdminVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * session登录验证 拦截器
 */

@Slf4j
@Component
public class SessionLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 简单的白名单，登录这个接口直接放行
        if ("/login".equals(request.getRequestURI())) {
            return true;
        }

        AdminVo adminVo = (AdminVo) request.getSession().getAttribute("admin");
        if (adminVo == null) {
            throw new BusinessException(ResultCode.USER_NOT_LOGGED_IN);
        }

        return true;
    }
}
