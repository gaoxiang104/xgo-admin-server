package pub.xgo.adminserver.service;

import pub.xgo.adminserver.model.dto.AdminDto;

import java.util.List;

public interface AdminService {
    /**
     * 查询某一个管理员信息
     *
     * @return
     */
    AdminDto queryAdminById(Integer id);
}
