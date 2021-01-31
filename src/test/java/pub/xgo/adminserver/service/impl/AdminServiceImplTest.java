package pub.xgo.adminserver.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pub.xgo.adminserver.model.dto.AdminDto;
import pub.xgo.adminserver.service.AdminService;


@SpringBootTest
@RunWith(SpringRunner.class)
class AdminServiceImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImplTest.class);

    @Autowired
    AdminService adminService;

    @Test
    void queryAdminById() {
        AdminDto dto = adminService.queryAdminById(1);
        LOGGER.info("queryAdminById() : dto = {}", dto);
    }
}