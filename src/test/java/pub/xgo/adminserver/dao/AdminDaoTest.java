package pub.xgo.adminserver.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pub.xgo.adminserver.model.enums.AdminStatusEnums;
import pub.xgo.adminserver.model.po.AdminPo;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
class AdminDaoTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminDaoTest.class);

    @Autowired
    AdminDao adminDao;

    @Test
    void insertSelective() {
        AdminPo po = new AdminPo();
        po.setAdminLoginName("admin");
        po.setAdminPasswrod("d7190eb194ff9494625514b6d178c87f99c5973e28c398969d2233f2960a573e");
        po.setAdminCreationTime(new Date());
        po.setAdminName("超级管理员");
        po.setAdminStatus(AdminStatusEnums.ENABLE);

        LOGGER.info("insertSelective() start : po = {}", po);

        int result = adminDao.insertSelective(po);
        LOGGER.info("insertSelective() end : po = {}", po);

    }

    @Test
    void updateByPrimaryKeySelective() {
        Integer adminPoId = 1;
        AdminPo po = new AdminPo();
        po.setAdminId(adminPoId);
        po.setAdminStatus(AdminStatusEnums.DISABLE);
        po.setAdminUpdateTime(new Date());
        int result = adminDao.updateByPrimaryKeySelective(po);
        LOGGER.info("selectByPrimaryKey() : result={}", result);
        po.setAdminStatus(AdminStatusEnums.ENABLE);
        po.setAdminUpdateTime(new Date());
        int result2 = adminDao.updateByPrimaryKeySelective(po);
        LOGGER.info("selectByPrimaryKey() : result2={}", result2);
        AdminPo poS = adminDao.selectByPrimaryKey(adminPoId);
        LOGGER.info("selectByPrimaryKey() : po={}", po);

    }

    @Test
    void selectByPrimaryKey() {
        Integer adminPoId = 1;
        AdminPo po = adminDao.selectByPrimaryKey(adminPoId);
        LOGGER.info("selectByPrimaryKey() : po={}", po);
    }
}