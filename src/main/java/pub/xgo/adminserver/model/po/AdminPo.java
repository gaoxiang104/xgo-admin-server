package pub.xgo.adminserver.model.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;
import pub.xgo.adminserver.model.enums.AdminStatusEnums;

/**
 * admin_admin
 *
 * @author
 */
@Data
@ToString(exclude = {"adminPasswrod"})
public class AdminPo implements Serializable {
    private static final long serialVersionUID = -2544580094298948860L;
    /**
     * 管理员ID
     */
    private Integer adminId;

    /**
     * 管理员登录账户名称
     */
    private String adminLoginName;

    /**
     * 管理员登录密码
     */
    private String adminPasswrod;

    /**
     * 管理员姓名
     */
    private String adminName;

    /**
     * 管理员状态；0：禁用，1：启用；默认启用。
     */
    private AdminStatusEnums adminStatus;

    /**
     * 管理员创建时间
     */
    private Date adminCreationTime;

    /**
     * 管理员修改时间
     */
    private Date adminUpdateTime;

}