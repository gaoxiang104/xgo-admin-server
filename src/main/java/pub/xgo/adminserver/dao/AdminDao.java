package pub.xgo.adminserver.dao;

import org.springframework.stereotype.Repository;
import pub.xgo.adminserver.model.po.AdminPo;

@Repository
public interface AdminDao {
    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminPo record);

    int insertSelective(AdminPo record);

    AdminPo selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AdminPo record);

    int updateByPrimaryKey(AdminPo record);
}