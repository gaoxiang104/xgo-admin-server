package pub.xgo.adminserver.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.xgo.adminserver.dao.AdminDao;
import pub.xgo.adminserver.model.dto.AdminDto;
import pub.xgo.adminserver.model.po.AdminPo;
import pub.xgo.adminserver.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    AdminDao adminDao;


    @Override
    public AdminDto queryAdminById(Integer id) {
        AdminDto result = new AdminDto();
        AdminPo po = adminDao.selectByPrimaryKey(id);
        BeanUtils.copyProperties(po, result);
        return result;
    }
}
