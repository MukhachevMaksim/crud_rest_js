package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.dao.RoleDao;
import web.model.Role;

import java.util.List;

@Repository
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public List<Role> listRoles() {
        return roleDao.listRoles();
    }
}
