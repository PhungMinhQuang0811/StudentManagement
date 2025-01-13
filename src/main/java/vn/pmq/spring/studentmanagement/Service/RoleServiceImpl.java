package vn.pmq.spring.studentmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.pmq.spring.studentmanagement.Model.Role;
import vn.pmq.spring.studentmanagement.Repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleRepository.getById(id);
    }
    public List<Role> getRolesByIds(List<Integer> roleIds) {
        return roleRepository.findAllById(roleIds);
    }

    @Override
    public List<Role> getRolesByAccount(int accountId) {
        return roleRepository.findRolesByAccountId(accountId);
    }
}
