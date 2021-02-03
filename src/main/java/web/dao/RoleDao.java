package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {
    Role getRoleById(Long id);
    List<Role> listRoles();
}
