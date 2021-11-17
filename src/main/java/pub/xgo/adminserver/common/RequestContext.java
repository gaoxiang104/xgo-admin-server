package pub.xgo.adminserver.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pub.xgo.adminserver.model.vo.AdminVo;

import javax.servlet.http.HttpServletRequest;

public class RequestContext {
    public static HttpServletRequest getCurrentRequest() {
        // 通过`RequestContextHolder`获取当前request请求对象
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
    }

    public static AdminVo getCurrentUser() {
        // 通过request对象获取session对象，再获取当前用户对象
        return (AdminVo)getCurrentRequest().getSession().getAttribute("admin");
    }
}
