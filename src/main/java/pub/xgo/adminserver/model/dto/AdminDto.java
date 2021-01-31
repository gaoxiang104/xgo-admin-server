package pub.xgo.adminserver.model.dto;

import lombok.Data;
import pub.xgo.adminserver.model.enums.AdminStatusEnums;

import java.io.Serializable;
import java.util.Date;

@Data
public class AdminDto implements Serializable {
    private static final long serialVersionUID = 2632842566400646791L;

    /**
     * 管理员ID
     */
    private Integer adminId;

    /**
     * 管理员登录账户名称
     */
    private String adminLoginName;

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
