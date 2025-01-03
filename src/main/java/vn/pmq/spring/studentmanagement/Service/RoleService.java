package vn.pmq.spring.studentmanagement.Service;

import vn.pmq.spring.studentmanagement.Model.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();
    public Role findById(int id);
    public List<Role> getRolesByIds(List<Integer> roleIds);
}
